package com.fanhehe.user.business.doll.wave.service;

import com.fanhehe.user.business.doll.wave.pojo.ElectricWaveUserRecord;
import com.fanhehe.user.business.doll.wave.pojo.repository.WaveUserRecordRepository;
import com.fanhehe.user.business.user.pojo.respository.user.UserBindingRepository;
import com.fanhehe.user.business.user.pojo.respository.user.UserRepository;
import com.fanhehe.user.common.util.OrderUtil;
import lombok.SneakyThrows;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

import java.util.Optional;

/**
 * @author fanhehe
 * @version 0.0.1
 * @date 2020/12/11 15:21
 */
@Service
public class WaveTransactionServiceImpl {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserBindingRepository userBindingRepository;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Autowired
    private WaveUserRecordRepository waveUserRecordRepository;

    @Transactional(rollbackFor = Exception.class)
    public void insert(Long id) {
        Optional<ElectricWaveUserRecord> waveRecord = waveUserRecordRepository.findById(id);

        ElectricWaveUserRecord target = new ElectricWaveUserRecord();

        waveRecord.ifPresent(item -> {
            BeanUtils.copyProperties(item, target);
            target.setId(null);
            target.setCode(OrderUtil.makeOrder());
            waveUserRecordRepository.save(target);
        });
    }

    @SneakyThrows
    public void throwException() {
        throw  new Exception();
    }
}
