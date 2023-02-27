package com.example.community.controller;

import com.example.community.entity.Question;
import com.example.community.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/question")
public class QuestionController {
    @Autowired
    QuestionService questionService;

    @PostMapping("/{uid}")
    public ResponseEntity addQuestion(@PathVariable String uid, @RequestBody Question question){
        return ResponseEntity.ok(questionService.addQuestion(uid, question));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteQuestion(@PathVariable Integer id){
        questionService.deleteQuestionById(id);
        return ResponseEntity.ok("删除成功");
    }

    @GetMapping("/{id}/{uid}")
    public ResponseEntity getQuestion(@PathVariable Integer id, @PathVariable String uid){
        return ResponseEntity.ok(questionService.getQuestion(id, uid));
    }

    @GetMapping("/user/{uid}")
    public ResponseEntity getUserQuestions(@PathVariable String uid){
        return ResponseEntity.ok(questionService.getUserQuestions(uid));
    }

    @GetMapping("/{uid}")
    public ResponseEntity getAllQuestions(@PathVariable String uid, @RequestParam(defaultValue = "0")Integer pageNum, @RequestParam(defaultValue = "3")Integer pageSize){
        return ResponseEntity.ok(questionService.getAllQuestions(uid, PageRequest.of(pageNum, pageSize)));
    }

    @GetMapping("/{id}/comments")
    public ResponseEntity getComments(@PathVariable Integer id){
        return ResponseEntity.ok(questionService.getComments(id));
    }

    @GetMapping("/{id}/answer")
    public ResponseEntity getAnswer(@PathVariable Integer id){
        return ResponseEntity.ok(questionService.getAnswer(id));
    }



    @PutMapping("/{id}/{uid}/following")
    public ResponseEntity followQuestion(@PathVariable Integer id, @PathVariable String uid){
        questionService.followQuestion(id, uid);
        return ResponseEntity.ok("");
    }

    @PutMapping("/{id}/{uid}/cancel")
    public ResponseEntity cancelFollowing(@PathVariable Integer id, @PathVariable String uid){
        questionService.cancelFollowing(id, uid);
        return ResponseEntity.ok("");
    }

    @PutMapping("/{id}/vote")
    public ResponseEntity vote(@PathVariable Integer id){
        questionService.voteQuestion(id);
        return ResponseEntity.ok("");
    }
}
