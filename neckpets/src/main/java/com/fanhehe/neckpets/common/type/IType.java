package com.fanhehe.neckpets.common.type;

import java.util.Optional;

import com.sun.istack.Nullable;

/**
 * @author fanhehe
 * @version 0.0.1
 * @date 2020/12/8 16:32
 */
@FunctionalInterface
public interface IType {
    /**
     * 获取类型信息
     *
     * @return 获取类型信息
     */
    String getType();

    /**
     * 生成IType实体
     *
     * @param type type
     * @return 结果
     */
    @Nullable
    static IType of(final String type) {
        if (type == null) {
            return null;
        }

        return () -> type;
    }

    /**
     * 获取类型
     *
     * @param type   类型
     * @param values 取值范围
     * @param <T>    j成了IType的类
     * @return 结果
     */
    static <T extends IType> Optional<T> getType(IType type, T[] values) {
        return type == null ? getType((String) null, values) : getType(type.getType(), values);
    }

    /**
     * 获取类型
     *
     * @param type   类型
     * @param values 所有取值范围
     * @param <T>    继承了IType的类
     * @return 结果
     */
    static <T extends IType> Optional<T> getType(String type, T[] values) {
        if (type == null) {
            return Optional.empty();
        }

        for (T item : values) {
            if (type.equals(item.getType())) {
                return Optional.of(item);
            }
        }

        return Optional.empty();
    }
}
