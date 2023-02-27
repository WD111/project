package com.example.community.service;

import com.example.community.dao.QuestionRepository;
import com.example.community.dao.TagRepository;
import com.example.community.dao.UserRepository;
import com.example.community.dto.AnswerDto;
import com.example.community.dto.CommentDto;
import com.example.community.dto.QuestionDto;
import com.example.community.dto.UserDto;
import com.example.community.entity.Answer;
import com.example.community.entity.Comment;
import com.example.community.entity.Question;
import com.example.community.entity.User;
import com.example.community.exception.ServiceException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class QuestionService {
    @Autowired
    QuestionRepository questionRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    TagRepository tagRepository;

    public QuestionDto addQuestion(String uid, Question question){
        if(userRepository.findById(uid).isPresent()){
            User user = userRepository.findById(uid).get();
            UserDto userDto = new UserDto();
            QuestionDto questionDto = new QuestionDto();
            question.setAuthor(user);
            for(int i : question.getTagIds()){
                question.getTags().add(tagRepository.findById(i).get());
            }
            questionRepository.saveAndFlush(question);
            //user.getQuestions().add(result);


            BeanUtils.copyProperties(user, userDto);
            BeanUtils.copyProperties(question, questionDto);
            questionDto.setUser(userDto);
            return questionDto;
        } else {
            throw new ServiceException("该用户不存在");
        }
    }

    public QuestionDto getQuestion(Integer id, String uid){
        Question question = questionRepository.findById(id).get();
        User author = question.getAuthor();
        QuestionDto questionDto = new QuestionDto();
        BeanUtils.copyProperties(question, questionDto);
        UserDto userDto = new UserDto();
        BeanUtils.copyProperties(author, userDto);
        questionDto.setUser(userDto);
        User user = userRepository.findById(uid).get();
        List<Question> questions = user.getFollowingQuestions();
        questionDto.setFollowing(questions.contains(question));
        return questionDto;
    }

    public List<QuestionDto> getUserQuestions(String uid){
        User user = userRepository.findById(uid).get();
        List<Question> questions = user.getQuestions();
        List<Question> following = user.getFollowingQuestions();
        List<QuestionDto> questionDtos = new ArrayList<>();
        for(Question question : questions){
            QuestionDto questionDto = new QuestionDto();
            BeanUtils.copyProperties(question, questionDto);
            questionDto.setFollowing(following.contains(question));
            questionDtos.add(questionDto);
        }
        return questionDtos;
    }

    public List<QuestionDto> getAllQuestions(String uid, Pageable pageable){
        User user = userRepository.findById(uid).get();
        List<Question> following = user.getFollowingQuestions();
        Page<Question> questions = questionRepository.findAll(pageable);
        //List<Question> questions = questionRepository.findAll();
        List<QuestionDto> questionDtos = new ArrayList<>();
        for(Question question : questions){
            QuestionDto questionDto = new QuestionDto();
            BeanUtils.copyProperties(question, questionDto);
            questionDto.setFollowing(following.contains(question));
            questionDtos.add(questionDto);
        }
        return questionDtos;
    }

    public List<CommentDto> getComments(Integer id){
        Question question = questionRepository.findById(id).get();
        List<Comment> comments = question.getComments();
        List<CommentDto> commentDtoList = new ArrayList<>();
        for(Comment comment : comments){
            CommentDto commentDto = new CommentDto();
            BeanUtils.copyProperties(comment, commentDto);
            commentDtoList.add(commentDto);
        }
        return commentDtoList;
    }

    public List<AnswerDto> getAnswer(Integer id){
        Question question = questionRepository.findById(id).get();
        List<Answer> answers = question.getAnswers();
        List<AnswerDto> answerDtos = new ArrayList<>();
        for(Answer answer : answers){
            AnswerDto answerDto = new AnswerDto();
            BeanUtils.copyProperties(answer, answerDto);
            User user = answer.getPublisher();
            UserDto userDto = new UserDto();
            BeanUtils.copyProperties(user, userDto);
            answerDto.setUserDto(userDto);
            answerDtos.add(answerDto);
        }
        return answerDtos;
    }

    public void deleteQuestionById(Integer id){
        questionRepository.deleteById(id);
    }

    public void followQuestion(Integer id, String uid){
        User user = userRepository.findById(uid).get();
        Question question = questionRepository.findById(id).get();
        user.getFollowingQuestions().add(question);
        userRepository.saveAndFlush(user);
    }

    public void cancelFollowing(Integer id, String uid){
        User user = userRepository.findById(uid).get();
        Question question = questionRepository.findById(id).get();
        user.getFollowingQuestions().remove(question);
        userRepository.saveAndFlush(user);
    }

    public void voteQuestion(Integer id){
        Question question = questionRepository.findById(id).get();
        int count = question.getVoteCount();
        question.setVoteCount(count + 1);
        questionRepository.saveAndFlush(question);
    }

}
