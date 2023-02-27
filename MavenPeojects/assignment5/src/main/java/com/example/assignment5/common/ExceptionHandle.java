package com.example.assignment5.common;

import cn.hutool.core.util.StrUtil;
import lombok.extern.slf4j.Slf4j;
import com.example.assignment5.common.Result;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class ExceptionHandle {
    @ExceptionHandler(value=ServiceException.class)
    public Result exceptionError(ServiceException e){
        log.error("业务异常", e);
        String code = e.getCode();
        if(StrUtil.isNotBlank(code)){
            return Result.error(code, e.getMessage());
        }
        return Result.error(e.getMessage());
    }
    @ExceptionHandler(value=Exception.class)
    public Result exceptionError(Exception e){
        log.error("系统错误", e);
        return Result.error("系统错误");
    }
}
