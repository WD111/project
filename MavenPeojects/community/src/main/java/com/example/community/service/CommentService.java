package com.example.community.service;

import com.example.community.dao.CommentRepository;
import com.example.community.dao.QuestionRepository;
import com.example.community.dao.UserRepository;
import com.example.community.dto.CommentDto;
import com.example.community.dto.UserDto;
import com.example.community.entity.Comment;
import com.example.community.entity.Question;
import com.example.community.entity.User;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CommentService {
    @Autowired
    CommentRepository commentRepository;
    @Autowired
    QuestionRepository questionRepository;
    @Autowired
    UserRepository userRepository;

    public CommentDto addQuestionComment(Integer id, String uid, Comment comment){
        Question question = questionRepository.findById(id).get();
        User user = userRepository.findById(uid).get();
        comment.setType("QuestionComment");
        comment.setUser(user);
        comment.setQuestion(question);
        question.getComments().add(comment);
        user.getComments().add(comment);
        Comment result = commentRepository.saveAndFlush(comment);
        CommentDto commentDto = new CommentDto();
        BeanUtils.copyProperties(result, commentDto);
        UserDto userDto = new UserDto();
        BeanUtils.copyProperties(user, userDto);
        commentDto.setUserDto(userDto);
        return commentDto;
    }
}
