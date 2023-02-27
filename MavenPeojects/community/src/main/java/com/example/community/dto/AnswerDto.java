package com.example.community.dto;

import com.example.community.entity.User;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class AnswerDto {
    Integer id;

    String content;
    Integer voteCount;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    Date publishTime;

    UserDto userDto;
}
