package com.example.community.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class User {
    @Id
    String id;

    String username;

    String remark;
//    String sex;

    String password;
//    String email;
////    String tel;

    @OneToMany(mappedBy = "author", cascade = CascadeType.REMOVE)
    List<Question> questions = new ArrayList<>();

    @OneToMany(mappedBy = "publisher", cascade = CascadeType.REMOVE)
    List<Answer> answers = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.REMOVE)
    List<Comment> comments = new ArrayList<>();

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
    List<Question> followingQuestions = new ArrayList<>();

//    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
//    List<Answer> votedAnswer = new ArrayList<>();



}
