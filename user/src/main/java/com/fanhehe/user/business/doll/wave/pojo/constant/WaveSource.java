package com.fanhehe.user.business.doll.wave.pojo.constant;

import com.fanhehe.user.common.enums.IEnum;

/**
 * @author fanhehe
 * @version 0.0.1
 * @date 2020/12/8 17:27
 */
public enum WaveSource implements IEnum {

    /**
     * 通用电波
     */
    COMMON("通用电波"),
    /**
     * 电波扫描
     */
    DEFAULT("电波扫描"),

    /**
     * 高能电波
     */
    HIGH_ENERGY("高能电波"),
    ;

    private final String description;

    WaveSource(String description) {
        this.description = description;
    }
}
