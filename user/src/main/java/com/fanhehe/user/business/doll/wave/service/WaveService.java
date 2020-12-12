package com.fanhehe.user.business.doll.wave.service;

import com.fanhehe.user.business.doll.wave.pojo.cond.WaveCond;
import com.fanhehe.user.business.doll.wave.pojo.result.WaveResult;
import com.fanhehe.user.common.result.IResult;
import com.fanhehe.user.common.user.IUser;
import org.springframework.scheduling.annotation.Scheduled;

/**
 * @author fanhehe
 * @version 0.0.1
 * @date 2020/12/8 15:06
 */
public interface WaveService {
    /**
     * 周期生成电波
     * @param user 用户信息
     * @param cond 参数信息
     * @return 结果
     */
    IResult<WaveResult> makeElectricWaveCycle(IUser user, WaveCond cond);

    void print();

    void prints();
}
