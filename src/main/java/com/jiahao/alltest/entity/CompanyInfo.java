package com.jiahao.alltest.entity;

import com.jiahao.alltest.annotation.ExcelColumn;

import java.io.Serializable;

/**
 * @author jiahao
 * @className: CompanyInfo
 * @Description: TODO
 * @date: 2021/6/24 21:42
 **/
public class CompanyInfo implements Serializable {

    @ExcelColumn(value = "公司名", col = 1)
    private String companyName;

    @Override
    public String toString() {
        return "UserModel{" +
                "companyName='" + companyName + '\'' +
                '}';
    }
}
