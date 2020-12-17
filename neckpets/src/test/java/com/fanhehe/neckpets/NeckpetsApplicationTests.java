package com.fanhehe.neckpets;

import com.fanhehe.neckpets.business.wave.service.WaveService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class NeckpetsApplicationTests {

    @Autowired
    private WaveService waveService;

    @Test
    void contextLoads() {
        waveService.testFind();
    }

}
