package com.fanhehe.user.business.doll.wave.pojo.repository;

import java.util.List;
import com.fanhehe.user.common.user.IUser;
import org.springframework.boot.autoconfigure.batch.BatchDataSource;
import org.springframework.data.jpa.repository.JpaRepository;
import com.fanhehe.user.business.doll.wave.pojo.ElectricWaveConfig;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.sql.DataSourceDefinition;

/**
 * @author fanhehe
 * @version 0.0.1
 * @date 2020/12/8 14:48
 */
public interface WaveConfigRepository extends JpaRepository<ElectricWaveConfig, Long>, JpaSpecificationExecutor<ElectricWaveConfig> {
    /**
     * 获取符合用户条件的电波配置表
     * @param user 用户信息
     * @return 结果
     */
    @Query(value = "FROM ElectricWaveConfig")
    List<ElectricWaveConfig> getElectricWaveConfig(IUser user);

    /**
     * 根据waveCodeList获取所有的配置
     * @param waveCodeList 配置列表
     * @return 结果
     */
    List<ElectricWaveConfig> findAllByWaveCodeIn(List<String> waveCodeList);

    /**
     * 增加电波每天已开出次数
     * @param config 配置
     */
    @Modifying(clearAutomatically = true)
    @Transactional(rollbackFor = Exception.class)
    @Query(value = "update ElectricWaveConfig set todayTimesCount = todayTimesCount + 1 where waveCode = :#{#config.waveCode}")
    void incrementElectricWaveConfigTodayTimes(@Param("config") ElectricWaveConfig config);
}
