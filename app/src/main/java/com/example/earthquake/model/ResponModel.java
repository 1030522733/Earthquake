package com.example.earthquake.model;

import java.io.Serializable;

/**
 * @author : J-T
 * date   : 2021/6/24
 * desc   :
 */
public class ResponModel<T> implements Serializable {
    public static final int RESULT_SUCCESS = 0;

    private T data;
    private int errorCode;
    private String errorMsg;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public boolean isSuccess(){
        return RESULT_SUCCESS == errorCode;
    }
}

