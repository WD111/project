package com.example.community.exception;


import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class ExceptionHandle {
    @ExceptionHandler(value=ServiceException.class)
    public ResponseEntity exceptionError(ServiceException e){
        log.error("业务异常", e);

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }
    @ExceptionHandler(value=Exception.class)
    public ResponseEntity exceptionError(Exception e){
        log.error("系统错误", e);
        return ResponseEntity.status(-1).body("系统错误");
    }
}
