package com.fanhehe.user.common.result;

/**
 * @author fanhehe
 * @version 0.0.1
 * @date 2020/12/8 15:07
 */
public interface IResult<T> extends IResultEnum {

    /**
     * 获取负载数据
     *
     * @return 获取负载数据
     */
    T getData();

    /**
     * 获取响应code
     *
     * @return 结果
     */
    @Override
    int getCode();

    /**
     * 获取响应信息
     *
     * @return 获取响应信息
     */
    @Override
    String getMessage();

    /**
     * 如果getCode == 0 则成功
     *
     * @return 是否成功
     */
    default boolean isSuccess() {
        return getCode() == 0;
    }
}
