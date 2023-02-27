package com.example.forum.common;

import lombok.Data;

@Data
public class Answer {
    private int error;
    private String reason;
    public static String SUCCESS="运行成功";
    public static String ERROR = "编译有错；" ;
    public static String RunTimeError = "运时错误";
    private String stdout;
    private String stderr;



}
