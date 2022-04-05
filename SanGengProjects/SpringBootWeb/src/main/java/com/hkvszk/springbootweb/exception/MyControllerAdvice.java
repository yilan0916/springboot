package com.hkvszk.springbootweb.exception;

import com.hkvszk.springbootweb.domain.ResponseResult;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author zhengkang6
 * @date 2022/4/4
 */
@ControllerAdvice
public class MyControllerAdvice {
    /**
     * 可以处理多个异常，
     * @ExceptionHandler({NullPointerException.class,ArithmeticException.class})
     *
     * 如果是前后端分离的项目，一般返回值类型定义为统一格式ResponseResult
     */
    @ExceptionHandler(RuntimeException.class)
    @ResponseBody
    public ResponseResult handlerException(Exception e) {
        //获取异常信息，存放入ResponseResult的msg属性
        String message = e.getMessage();
        //注意：实际项目中不能写300，要使用常量
        ResponseResult result = new ResponseResult(300, message);
        //把ResponseResult作为返回值返回，要求到时候转换成json存入响应体中
        return result;
    }
}
