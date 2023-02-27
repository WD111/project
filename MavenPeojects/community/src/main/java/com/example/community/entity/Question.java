package com.example.community.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sun.org.apache.xpath.internal.operations.Bool;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@Data
@Entity
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    String title;
    String body;

    Integer viewCount = 0;
    Integer voteCount = 0;
    Integer answerCount = 0;
    Integer voted = 0;
    Boolean solved = false;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    Date publishTime = new Date();

    @OneToMany(mappedBy = "question", cascade = CascadeType.REMOVE)
    List<Comment> comments = new ArrayList<>();

    @OneToMany(mappedBy = "question", cascade = CascadeType.REMOVE)
    List<Answer> answers = new ArrayList<>();


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "author_id", referencedColumnName = "id")
    User author;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
    List<Tag> tags = new ArrayList<>();

    @Transient
    List<Integer> tagIds = new ArrayList<>();

}
