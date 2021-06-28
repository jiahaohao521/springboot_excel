package com.jiahao.alltest.exception;

/**
 * @author jiahao
 * @className: NullPointException
 * @Description: TODO
 * @date: 2021/6/28 13:25
 **/
public class CustomNullPointException extends RuntimeException{

    protected Integer errorCode;
    protected String errorMsg;

    public CustomNullPointException(){

    }

    public CustomNullPointException(Integer errorCode, String errorMsg) {
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

    public Integer getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(Integer errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }
}
