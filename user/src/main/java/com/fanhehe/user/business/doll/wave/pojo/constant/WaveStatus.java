package com.fanhehe.user.business.doll.wave.pojo.constant;

import com.fanhehe.user.common.enums.IEnum;

/**
 * @author fanhehe
 * @version 0.0.1
 * @date 2020/12/8 17:24
 */
public enum WaveStatus implements IEnum {
    /**
     * 初始状态
     */
    INIT("初始状态"),
    /**
     * 已解开电波
     */
    FINISH_OPEN("已解开电波"),

    /**
     * 已完成电波任务
     */
    FINISH_TASK("已完成电波任务"),

    /**
     * 已完成电波任务
     */
    FINISH_PRIZE("已领取电波奖励"),

    ;

    private final String description;

    WaveStatus(String description) {
        this.description = description;
    }

    @Override
    public String getDescription() {
        return description;
    }
}
