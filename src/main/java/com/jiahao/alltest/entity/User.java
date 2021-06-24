package com.jiahao.alltest.entity;

/**
 * @author jiahao
 * @className: User
 * @Description: TODO
 * @date: 2021/6/24 22:06
 **/
public class User {
    public String name;
    public String addr;
    public int age;

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", addr='" + addr + '\'' +
                ", age=" + age +
                '}';
    }
}
