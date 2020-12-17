package com.fanhehe.neckpets.business.wave.constant;

import com.fanhehe.neckpets.common.type.IEnum;

/**
 * @author fanhehe
 * @version 0.0.1
 * @date 2020/12/14 21:32
 */
public enum WaveStatus implements IEnum {
    /**
     * 电波状态，初始化
     */
    INIT,
    /**
     * 完成破解
     */
    FINISH_OPEN,
    /**
     * 完成任务
     */
    FINISH_TASK,
    /**
     * 完成奖励
     */
    FINISH_PRIZE,
    ;
}
