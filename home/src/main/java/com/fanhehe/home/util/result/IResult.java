package com.fanhehe.home.util.result;

import java.io.Serializable;

public interface IResult<T> extends Serializable {

    int SUCCESS = 0;

    T getData();

    int getCode();

    String getMessage();

    default boolean isFailure() {
        return !isSuccess();
    }

    default boolean isSuccess() {
        return getCode() == SUCCESS;
    }
}
