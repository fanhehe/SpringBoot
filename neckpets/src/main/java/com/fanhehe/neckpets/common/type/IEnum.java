package com.fanhehe.neckpets.common.type;

import org.apache.commons.lang3.StringUtils;
import org.checkerframework.checker.nullness.Opt;

import java.util.Optional;

/**
 * @author fanhehe
 * @version 0.0.1
 * @date 2020/12/8 15:49
 */
@FunctionalInterface
public interface IEnum extends IType {

    /**
     * 枚举存在name方法
     *
     * @return 枚举存在name方法
     */
    String name();

    /**
     * 获取类型
     *
     * @return 获取类型
     */
    @Override
    default String getType() {
        return name();
    }

    /**
     * 获取备注
     *
     * @return 获取备注
     */
    default String getDescription() {
        return "";
    }

    /**
     * 获取所有取值
     *
     * @return 取值
     */
    static <T extends IEnum> T[] values() {
        return null;
    }
}
