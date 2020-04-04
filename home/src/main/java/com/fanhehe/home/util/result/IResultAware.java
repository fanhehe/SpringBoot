package com.fanhehe.home.util.result;

import java.io.Serializable;

public interface IResultAware<T> extends Serializable {
    void setData(T data);

    void setCode(int code);

    void setMessage(String message);
}
