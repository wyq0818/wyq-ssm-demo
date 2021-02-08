package com.wyq.cloud.producer.config;


import com.wyq.cloud.producer.component.response.Response;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.validation.BindException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.stream.Collectors;

/*
 * @Author:wuyongqiang
 * @Date:2020-12-23 11:28:11:28
 * SpringMVC统一异常处理
 * 注:@ControllerAdvice为Controller层增强器,其只能处理Controller层抛出的异常;
 * 由于代码间的层级调用机制  、异常的处理机制等,所以这里处理Controller层的异常,就相当于处理了全局异常
 */
@ControllerAdvice
public class GlobalExceptionConfig {

    //处理Get请求中 使用@Valid 验证路径中请求实体校验失败后抛出的异常，BindException
    @ExceptionHandler(BindException.class)
    @ResponseBody
    public Response BindExceptionHandler(BindException e) {
        String message = e.getBindingResult().getAllErrors().stream().map(DefaultMessageSourceResolvable::getDefaultMessage).collect(Collectors.joining());
        return Response.createByException(message);
    }

    //处理请求参数格式错误 @RequestParam上validate失败后抛出的异常是javax.validation.ConstraintViolationException
    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseBody
    public Response ConstraintViolationExceptionHandler(ConstraintViolationException e) {
        String message = e.getConstraintViolations().stream().map(ConstraintViolation::getMessage).collect(Collectors.joining());
        return Response.createByException(message);
    }

    //处理请求参数格式错误 @RequestBody上validate失败后抛出的异常是MethodArgumentNotValidException异常。
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    public Response MethodArgumentNotValidExceptionHandler(MethodArgumentNotValidException e) {
        String message = e.getBindingResult().getAllErrors().stream().map(DefaultMessageSourceResolvable::getDefaultMessage).collect(Collectors.joining());
        return Response.createByException(message);
    }

}
