package com.fanhehe.home.util.result;

public class Result<T> extends AbstractResult<T> {

    private static final IResult SUCCESS = new Result<>(0, "", null);
    private static final IResult FAILURE = new Result<>(500, "", null);

    private Result(int code, String message, T data) {
        this.setCode(code);
        this.setData(data);
        this.setMessage(message);
    }

    public static <T> IResult<T> success() {
        return success(null);
    }

    public static <T> IResult<T> failure() {
        return failure(FAILURE, null);
    }

    public static <T> IResult<T> success(T data) {
        return makeResult(SUCCESS, data);
    }

    public static <T> IResult<T> failure(IResult<T> result, T data) {
        return makeResult(result, data);
    }


    private static <T> IResult<T> makeResult(IResult<T> k, T data) {
        return new Result<>(k.getCode(), k.getMessage(), data != null ? data : k.getData());
    }

    public static <T> IResult<T> convert(IResult<T> result) {
        if (result == null) {
            return Result.failure(FAILURE, null);
        }

        if (result.isSuccess()) {
            return success(result.getData());
        }

        return failure(result, result.getData());
    }
}
