package com.fanhehe.user.common.enums;

import com.fanhehe.user.common.enums.IType;
import org.apache.commons.lang3.StringUtils;

/**
 * @author fanhehe
 * @version 0.0.1
 * @date 2020/12/8 15:49
 */
public interface IEnum extends IType {

    IEnum NONE = new IEnum() {
        /**
         * 枚举存在name方法
         *
         * @return 枚举存在name方法
         */
        @Override
        public String name() {
            return "NULL";
        }
    };

    /**
     * 枚举存在name方法
     * @return 枚举存在name方法
     */
    default String name() {
        return "";
    }

    /**
     * 获取类型
     * @return 获取类型
     */
    @Override
    default String getType() {
        return name();
    }

    /**
     * 获取备注
     * @return 获取备注
     */
    default String getDescription() {
        return "";
    }

    /**
     * 获取所有取值
     * @return 取值
     */
    static <T extends IEnum> T[] values() {
        return null;
    }

    /**
     * 获取枚举类型
     * @param type 类型
     * @return 结果
     */
    static IEnum getEnum(String type) {
        return getEnum(IType.of(type));
    }

    /**
     * 获取枚举类型
     * @param type 类型
     * @return 结果
     */
    static IEnum getEnum(IType type) {
        if (type == null || StringUtils.isBlank(type.getType())) {
            return NONE;
        }

        assert values() != null;

        for (IEnum item: values()) {
            if (type.getType().equals(item.getType())) {
                return item;
            }
        }

        return NONE;
    }
}
