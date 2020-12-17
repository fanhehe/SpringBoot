package com.fanhehe.user.business.doll.wave.pojo.constant;

import com.fanhehe.user.common.enums.IEnum;
import org.apache.commons.lang3.StringUtils;

/**
 * @author fanhehe
 * @version 0.0.1
 * @date 2020/12/8 17:26
 */
public enum WaveOpen implements IEnum {

    /**
     * 异常情况
     */
    NONE("异常情况"),

    /**
     * 免费开启
     */
    FREE("免费开启"),

    /**
     * 分享开启
     */
    SHARE("分享开启"),

    /**
     * 能量开启
     */
    ENERGY("能量开启"),

    ;

    private final String description;

    WaveOpen(String description) {
        this.description = description;
    }


    @Override
    public String getDescription() {
        return description;
    }

    public static WaveOpen getWaveOpen(String type) {
        if (StringUtils.isBlank(type)) {
            return NONE;
        }

        for (WaveOpen item : WaveOpen.values()) {
            if (StringUtils.equals(item.getType(), type)) {
                return item;
            }
        }

        return NONE;
    }
}
