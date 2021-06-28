package com.jiahao.alltest.common;

import com.jiahao.alltest.exception.CustomNullPointException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author jiahao
 * @className: CustomExcetion
 * @Description: 自定义异常类
 * @date: 2021/6/28 13:24
 **/
@ControllerAdvice
public class CustomException extends NullPointerException{

    private static final Logger log = LoggerFactory.getLogger(CustomException.class);

    @ExceptionHandler(value = CustomNullPointException.class)
    @ResponseBody
    public Result nullPointException(CustomNullPointException e){
        log.error("自定义异常：空指针异常， 错误码:{}, 错误信息:{}", e.getErrorCode(), e.getErrorMsg());
        return Result.customResult(e);
    }

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result nullPointException(Exception e){
        log.error("其他异常， 异常信息:{}", ExceptionEnum.INTERNAL_ERROR);
        return Result.otherException(ExceptionEnum.INTERNAL_ERROR);
    }

}
