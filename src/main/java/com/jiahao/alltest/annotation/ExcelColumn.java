package com.jiahao.alltest.annotation;

import java.lang.annotation.*;

/**
 * @author jiahao
 * @className: ExcelColumn
 * @Description: TODO
 * @date: 2021/6/24 21:44
 **/
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ExcelColumn {

    /**
     * Excel标题
     */
    String value() default "";

    /**
     * Excel从左往右排列位置
     */
    int col() default 0;


}
