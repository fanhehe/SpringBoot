package com.fanhehe.user.common.result;

/**
 * @author fanhehe
 * @version 0.0.1
 * @date 2020/12/8 15:22
 */
public final class Result<T> extends AbstractResult<T> {
    /**
     * 返回成功无参
     *
     * @param <T> 模板T
     * @return IResult
     */
    public static <T> IResult<T> success() {
        return success(null);
    }

    /**
     * 返回失败无参
     *
     * @param <T> 模板T
     * @return IResult
     */
    public static <T> IResult<T> failure() {
        return failure(FAILURE);
    }

    /**
     * 返回成功无参
     *
     * @param <T> 模板T
     * @return IZuibonResult
     */
    public static <T> IResult<T> success(T data) {
        return makeResult(SUCCESS, data);
    }

    /**
     * 失败，仅返回原因
     * @param resultEnum 结果
     * @param <T> 模板T
     * @return 结果
     */
    public static <T> IResult<T> failure(IResultEnum resultEnum) {
        return failure(resultEnum, null);
    }

    /**
     * 失败，返回原因 + 数据
     * @param resultEnum 结果
     * @param data 数据
     * @param <T> 模板T
     * @return 结果
     */
    public static <T> IResult<T> failure(IResultEnum resultEnum, T data) {
        return makeResult(resultEnum, data);
    }
}
