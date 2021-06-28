package com.jiahao.alltest.common;

import com.jiahao.alltest.exception.CustomNullPointException;

/**
 * @author jiahao
 * @className: Result
 * @Description: TODO
 * @date: 2021/6/28 21:46
 **/
public class Result<T> {

    private String message;

    private int code;

    private T data;

    public String getMessage() {
        return message;
    }

    public Result<T> setMessage(String message) {
        this.message = message;
        return this;
    }

    public int getCode() {
        return code;
    }

    public Result<T> setCode(int code) {
        this.code = code;
        return this;
    }

    public T getData() {
        return data;
    }

    public Result<T> setData(T data) {
        this.data = data;
        return this;
    }

    @Override
    public String toString() {
        return "Result{" +
                "message='" + message + '\'' +
                ", code=" + code +
                ", data=" + data +
                '}';
    }

    /**
     * 返回成功的构造器， 默认返回成功
     */
    public Result() {
        this.message = ExceptionEnum.SUCCESS.message;
        this.code = ExceptionEnum.SUCCESS.code;
    }

    /**
     * 处理自定义异常的构造器
     */
    public static Result<CustomNullPointException> customResult(CustomNullPointException customNullPointException) {
        Result<CustomNullPointException> result = new Result<>();
        result.setCode(customNullPointException.getErrorCode());
        result.setMessage(customNullPointException.getMessage());
        result.setData(null);
        return result;
    }

    /**
     * 处理其他的异常
     */
    public static Result<Exception> otherException(ExceptionEnum exceptionEnum) {
        Result<Exception> result = new Result<>();
        result.setCode(exceptionEnum.getCode());
        result.setMessage(exceptionEnum.getMessage());
        result.setData(null);
        return result;
    }


}
