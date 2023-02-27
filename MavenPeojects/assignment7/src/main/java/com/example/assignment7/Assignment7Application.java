package com.example.assignment7;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class Assignment7Application {

    public static void main(String[] args) {
        SpringApplication.run(Assignment7Application.class, args);
        log.info("项目启动成功");
    }

}
