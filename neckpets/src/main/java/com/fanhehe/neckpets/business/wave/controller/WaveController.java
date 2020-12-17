package com.fanhehe.neckpets.business.wave.controller;

import com.alibaba.fastjson.JSON;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import com.fanhehe.neckpets.business.wave.pojo.cond.WaveCond;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author fanhehe
 * @version 0.0.1
 * @date 2020/12/16 17:16
 */
@RestController
public class WaveController {
    @GetMapping("getWaveList")
    public String getWaveList(@Validated WaveCond waveCond) {
        return JSON.toJSONString(waveCond);
    }
}
