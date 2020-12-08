package com.fanhehe.user.business.doll.wave.service;

import com.fanhehe.user.business.doll.wave.pojo.ElectricWaveConfig;
import com.fanhehe.user.business.doll.wave.pojo.ElectricWaveUserRecord;
import com.fanhehe.user.business.doll.wave.pojo.cond.WaveCond;
import com.fanhehe.user.business.doll.wave.pojo.constant.WaveConfig;
import com.fanhehe.user.business.doll.wave.pojo.constant.WaveOpen;
import com.fanhehe.user.business.doll.wave.pojo.constant.WaveSource;
import com.fanhehe.user.business.doll.wave.pojo.constant.WaveStatus;
import com.fanhehe.user.business.doll.wave.pojo.repository.WaveConfigRepository;
import com.fanhehe.user.business.doll.wave.pojo.repository.WaveHighEnergyRepository;
import com.fanhehe.user.business.doll.wave.pojo.repository.WaveUserRecordRepository;
import com.fanhehe.user.business.doll.wave.pojo.result.WaveRecord;
import com.fanhehe.user.business.doll.wave.pojo.result.WaveResult;
import com.fanhehe.user.business.doll.wave.pojo.result.WaveResultEnum;
import com.fanhehe.user.common.enums.IEnum;
import com.fanhehe.user.common.result.IResult;
import com.fanhehe.user.common.result.Result;
import com.fanhehe.user.common.user.IUser;
import com.fanhehe.user.common.util.OrderUtil;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import lombok.SneakyThrows;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.sql.Timestamp;
import java.util.*;

/**
 * @author fanhehe
 * @version 0.0.1
 * @date 2020/12/8 15:06
 */
@Service
public class WaveServiceImpl implements WaveService {

    @Autowired
    private WaveConfigRepository waveConfigRepository;

    @Autowired
    private WaveHighEnergyRepository waveHighEnergyRepository;

    @Autowired
    private WaveUserRecordRepository waveUserRecordRepository;

    private static final Logger logger = LoggerFactory.getLogger(WaveServiceImpl.class);

    /**
     * 周期生成电波
     *
     * @param user 用户信息
     * @param cond 参数信息
     * @return 结果
     */
    @Override
    @SneakyThrows
    public IResult<WaveResult> makeElectricWaveCycle(IUser user, WaveCond cond) {

        long nexTime;
        WaveResult result = new WaveResult();

        result.setServerTime(System.currentTimeMillis());
        List<ElectricWaveConfig> configList = waveConfigRepository.getElectricWaveConfig(user);

        // 配置有问题，无法开启电波
        if (CollectionUtils.isEmpty(configList)) {
            result.setNextTime(-1);
            return Result.failure(WaveResultEnum.EMPTY);
        }

        int times = waveUserRecordRepository.getElectricWaveCycleTodayTimes(user, new Date());

        // 用户今天已经产生电波超过5次，则不再生成电波
        if (times > WaveConfig.WAVE_DAILY_PERSONAL_LIMIT) {

            Date tomorrow = DateFormatUtils
                    .ISO_DATE_FORMAT
                    .parse(
                            DateFormatUtils
                                    .ISO_DATE_FORMAT
                                    .format(DateUtils.addDays(new Date(), 1))
                    );

            result.setNextTime(tomorrow.getTime() - result.getServerTime());

            return Result.failure(WaveResultEnum.EMPTY, result);
        }

        ElectricWaveUserRecord userRecord = waveUserRecordRepository.getElectricWaveCycleUserRecord(user);

        int canMakeWaveSpecial = canMakeWaveFromSpecialList(userRecord);

        logger.info("canMakeWaveSpecial的结果为: {}", canMakeWaveSpecial);

        // 当前用户最近的一条电波在4小时之内，无法生存新的电波
        if (canMakeWaveSpecial < 0 && userRecord != null && userRecord.getGmtCreate().after(DateUtils.addSeconds(new Date(), -1 * WaveConfig.WAVE_CYCLE_BETWEEN))) {
            nexTime = WaveConfig.WAVE_CYCLE_BETWEEN * WaveConfig.ONE_SECOND - (result.getServerTime() - userRecord.getGmtCreate().getTime());
            result.setNextTime(nexTime > 0 ? nexTime : 0L);
            return Result.failure(WaveResultEnum.EMPTY, result);
        }

        int random = (int)(Math.random() * 100);

        if (canMakeWaveSpecial > 0) {
            random = (int)(Math.random() *Math.max(0, 100 - canMakeWaveSpecial));
            logger.info("本次因canMakeWaveSpecial新生成的概率为{}", random);
        }

        logger.info("本次的随机数为: {}", random);

        // 本次没有电波
        if (random >= WaveConfig.WAVE_CYCLE_RATIO) {
            result.setNextTime(WaveConfig.WAVE_CYCLE_BETWEEN_MILLISECOND);
            return Result.failure(WaveResultEnum.EMPTY, result);
        }

        ElectricWaveConfig config = getRandomOneFromList(configList);

        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        java.sql.Date date = new java.sql.Date(System.currentTimeMillis());
        userRecord = new ElectricWaveUserRecord();
        userRecord.setGmtDate(date);
        userRecord.setSourceCode("");
        userRecord.setGmtCreate(timestamp);
        userRecord.setGmtModify(timestamp);
        userRecord.setUserId(user.getUserId());
        userRecord.setPosition(0);
        userRecord.setWaveCode(config.getWaveCode());
        userRecord.setStatus(WaveStatus.INIT.getType());
        userRecord.setCode(OrderUtil.makeOrder());
        userRecord.setSourceType(WaveSource.DEFAULT.getType());

        if (StringUtils.equals(config.getOpenMethod(), WaveOpen.FREE.getType())) {
            userRecord.setStatus(WaveStatus.FINISH_OPEN.getType());
        }

        waveUserRecordRepository.save(userRecord);

        waveConfigRepository.incrementElectricWaveConfigTodayTimes(config);

        result.setRecordList(buildElectricWaveUserRecord(Collections.singletonList(userRecord)));
        return Result.success();
    }

    public int canMakeWaveFromSpecialList(ElectricWaveUserRecord userRecord) {

        long today = makeToday().getTime();

        long now = System.currentTimeMillis() - today;

        for (Long item: WaveConfig.WAVE_SPECIAL_TIME) {

            // 现在时间减去分段时间
            long diff = now - item;
            // 3 分钟内必出电波
            if (diff > 0 && diff < WaveConfig.WAVE_NEAR_SPECIAL_TIME_MILLISECONDS) {

                if (userRecord != null && userRecord.getGmtCreate().getTime() - today - item > 0) {
                    // 本三分钟内如果出现过电波则略过
                    logger.info("本三分钟已出现过电波，忽略: {} -> {}", userRecord.getUserId(), userRecord.getCode());
                    return -1;
                }

                return (int) (((diff * 1.0D) / (WaveConfig.WAVE_NEAR_SPECIAL_TIME_MILLISECONDS - WaveConfig.WAVE_CYCLE_BETWEEN_MILLISECOND)) * 100D);
            }
        }

        return -1;
    }

    /**
     * 从 configList中，按权重随机一个
     *
     * @param configList 配置列表
     * @return 结果
     */
    public ElectricWaveConfig getRandomOneFromList(List<ElectricWaveConfig> configList) {
        if (CollectionUtils.isEmpty(configList)) {
            return null;
        }

        int sum = 0;
        int current = 0;

        for (ElectricWaveConfig config : configList) {
            sum += config.getWeight();
        }

        int random = (int)(Math.random() * sum);

        logger.info("getRandomOneFromWaveConfig: random={}", random);

        for (ElectricWaveConfig config : configList) {
            current += config.getWeight();

            if (current >= random) {
                logger.info("getRandomOneFromWaveConfig: current = {} >= random={}", current, random);
                return config;
            }
        }

        logger.info("getRandomOneFromWaveConfig: 随机一个 random={}", random);

        return configList.get((int)(Math.random() * configList.size()));
    }

    @SneakyThrows
    private Date makeToday() {
        return DateFormatUtils.ISO_8601_EXTENDED_DATE_FORMAT.parse(DateFormatUtils.ISO_8601_EXTENDED_DATE_FORMAT.format(new Date()));
    }

    private Map<String, ElectricWaveConfig> getWaveCodeConfigMap(List<ElectricWaveUserRecord> list) {
        if (CollectionUtils.isEmpty(list)) {
            return Collections.emptyMap();
        }

        List<String> waveCodeList = Lists.transform(list, ElectricWaveUserRecord::getWaveCode);

        List<ElectricWaveConfig> configList = waveConfigRepository.findAllByWaveCodeIn(waveCodeList);

        return Maps.uniqueIndex(configList, ElectricWaveConfig::getWaveCode);
    }

    /**
     * 重构record列表
     *
     * @param list 列表
     * @return 结果
     */
    protected List<WaveRecord> buildElectricWaveUserRecord(List<ElectricWaveUserRecord> list) {

        if (CollectionUtils.isEmpty(list)) {
            return Collections.emptyList();
        }

        List<WaveRecord> result = new ArrayList<>();
        Map<String, ElectricWaveConfig> configMap = getWaveCodeConfigMap(list);

        for (ElectricWaveUserRecord item : list) {
            WaveRecord record = new WaveRecord();
            ElectricWaveConfig config = configMap.get(item.getWaveCode());

            record.setCode(item.getCode());
            record.setWaveName(config.getWaveName());
            record.setWaveImage(config.getWaveImage());
            record.setRoomCode(config.getRoomCode());
            record.setOpenMethod(config.getOpenMethod());
            record.setOpenMethodValue(config.getOpenMethodValue());
            record.setCreateTime(item.getGmtCreate().getTime());
            record.setPosition(item.getPosition());
            record.setExpireTime(DateUtils.addSeconds(item.getGmtCreate(), WaveConfig.WAVE_VALID_TIME).getTime());
            record.setEnergyToOldUser(WaveConfig.WAVE_INVITE_OLD_TO_ENERGY);

            record.setWaveOpenMessage(config.getWaveOpenMessage());
            record.setWavePrizeMessage(config.getWavePrizeMessage());
            record.setWaveNoticeMessage(config.getWaveNoticeMessage());
            record.setWaveShareMessage(config.getWaveShareMessage());

            IEnum recordStatus = IEnum.getEnum(item.getStatus());

            record.setPayPrice(config.getPayPrice());
            record.setPrizeType(config.getPrizeType());
            record.setWaveStatus(recordStatus.getType());
            record.setWaveStatusName(recordStatus.getDescription());

            switch (WaveOpen.getWaveOpen(config.getOpenMethod())) {
                case NONE:
                case ENERGY:
                case FREE:
                default:
                    record.setOpenCurrentValue(0);
                    break;
                case SHARE:
//                    record.setOpenCurrentValue(makeShareRecord(item).getAmount());
                    break;
            }

            result.add(record);
        }

        return result;
    }

}
