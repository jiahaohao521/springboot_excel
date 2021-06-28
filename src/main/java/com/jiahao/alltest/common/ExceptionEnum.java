package com.jiahao.alltest.common;

/**
 * @author jiahao
 * @className: ExceptionEunm
 * @Description: TODO
 * @date: 2021/6/28 21:48
 **/
public enum ExceptionEnum {

    BAD_PARAM(400, "请求参数异常"),

    URL_ERROR(404, "页面找不到"),

    INTERNAL_ERROR(500, "内部错误"),

    SUCCESS(200, "成功");

    public int code;

    public String message;

    public int getCode() {
        return code;
    }

    public ExceptionEnum setCode(int code) {
        this.code = code;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public ExceptionEnum setMessage(String message) {
        this.message = message;
        return this;
    }

    ExceptionEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }
}
