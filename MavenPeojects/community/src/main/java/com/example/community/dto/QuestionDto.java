package com.example.community.dto;

import com.example.community.entity.Tag;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
public class QuestionDto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    String title;
    String body;
    Integer viewCount;
    Integer voteCount;
    Integer answerCount;
    Integer voted;
    Boolean solved;
    Boolean following;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    Date publishTime;

    UserDto user;
    List<Tag> tags = new ArrayList<>();
}
