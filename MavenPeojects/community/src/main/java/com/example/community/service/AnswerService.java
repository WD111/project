package com.example.community.service;

import com.example.community.dao.AnswerRepository;
import com.example.community.dao.QuestionRepository;
import com.example.community.dao.UserRepository;
import com.example.community.dto.AnswerDto;
import com.example.community.dto.UserDto;
import com.example.community.entity.Answer;
import com.example.community.entity.Question;
import com.example.community.entity.User;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AnswerService {
    @Autowired
    AnswerRepository answerRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    QuestionRepository questionRepository;

    public AnswerDto addAnswer(Integer id, String uid, Answer answer){
        User user = userRepository.findById(uid).get();
        Question question = questionRepository.findById(id).get();
        answer.setPublisher(user);
        answer.setQuestion(question);
        answerRepository.saveAndFlush(answer);

        AnswerDto answerDto = new AnswerDto();
        UserDto userDto = new UserDto();
        BeanUtils.copyProperties(user, userDto);
        BeanUtils.copyProperties(answer, answerDto);
        answerDto.setUserDto(userDto);
        return answerDto;
    }

    public void voteAnswer(Integer id){
        Answer answer = answerRepository.findById(id).get();
        int count = answer.getVoteCount();
        answer.setVoteCount(count + 1);
        answerRepository.saveAndFlush(answer);
    }
}
