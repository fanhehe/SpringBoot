package com.fanhehe.user.common.enums;

/**
 * @author fanhehe
 * @version 0.0.1
 * @date 2020/12/8 16:32
 */
public interface IType {
    /**
     * 获取类型信息
     * @return 获取类型信息
     */
    String getType();

    /**
     * 生成IType实体
     * @param type type
     * @return 结果
     */
    static IType of(final String type) {
        if (type == null) {
            return null;
        }

        return () -> type;
    }
}
