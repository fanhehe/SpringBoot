package com.fanhehe.user.common.result;

/**
 * @author fanhehe
 * @version 0.0.1
 * @date 2020/12/8 15:27
 */
public abstract class AbstractResult<T> implements IResult<T> {
    private T data;
    private int code;
    private String message;

    @Override
    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * 如果非success则失败
     * @return 是否失败
     */
    public boolean isFailure() {
        return !isSuccess();
    }

    /**
     * 生成一个IResult
     * @param resultEnum 信息
     * @param data 负载数据
     * @param <T> 返回数据类型
     * @return 结果
     */
    protected static <T> IResult<T> makeResult(IResultEnum resultEnum, T data) {
        Result<T> result = new Result<>();
        result.setData(data);
        result.setCode(resultEnum.getCode());
        result.setMessage(resultEnum.getMessage());
        return result;
    }

}
