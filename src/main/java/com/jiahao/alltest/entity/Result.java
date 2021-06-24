package com.jiahao.alltest.entity;

/**
 * @author jiahao
 * @className: Result
 * @Description: TODO
 * @date: 2021/6/24 22:03
 **/
public class Result<T> {

    public Integer code;

    public String message;

    public T data;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Result() {
        this(200, "成功");
    }

    public Result(int code, String message) {
        this.code = code;
        this.message = message;
    }
}
