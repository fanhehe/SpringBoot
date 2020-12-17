package com.fanhehe.user.common.result;

import com.fanhehe.user.common.enums.IEnum;

/**
 * @author fanhehe
 * @version 0.0.1
 * @date 2020/12/8 15:10
 */
public interface IResultEnum extends IEnum {
    /**
     * 获取code
     *
     * @return code
     */
    default int getCode() {
        return 0;
    }

    /**
     * 获取message
     *
     * @return message
     */
    default String getMessage() {
        return "";
    }
}
