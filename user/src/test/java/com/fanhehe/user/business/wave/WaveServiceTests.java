package com.fanhehe.user.business.wave;

import com.fanhehe.user.business.doll.wave.pojo.ElectricWaveUserRecord;
import com.fanhehe.user.business.doll.wave.pojo.repository.WaveUserRecordRepository;
import com.fanhehe.user.business.user.pojo.respository.user.UserBindingRepository;
import com.fanhehe.user.common.util.OrderUtil;
import lombok.SneakyThrows;
import org.junit.runner.RunWith;
import com.fanhehe.user.UserApplication;
import com.fanhehe.user.business.user.pojo.respository.user.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

import java.util.Optional;

/**
 * @author fanhehe
 * @version 0.0.1
 * @date 2020/12/11 15:12
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = UserApplication.class)
public class WaveServiceTests {
}
