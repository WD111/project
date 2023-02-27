package com.example.community.controller;

import com.example.community.entity.Answer;
import com.example.community.service.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/answer")
public class AnswerController {
    @Autowired
    AnswerService answerService;

    @PostMapping("/{id}/{uid}")
    public ResponseEntity addAnswer(@PathVariable Integer id, @PathVariable String uid, @RequestBody Answer answer){
        return ResponseEntity.ok(answerService.addAnswer(id, uid, answer));
    }
}
