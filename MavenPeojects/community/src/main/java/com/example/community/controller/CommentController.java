package com.example.community.controller;

import com.example.community.entity.Comment;
import com.example.community.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/comment")
public class CommentController {
    @Autowired
    CommentService commentService;

    @PostMapping("/{id}/{uid}/question")
    public ResponseEntity addQuestionComment(@PathVariable Integer id, @PathVariable String uid, @RequestBody Comment comment){
        return ResponseEntity.ok(commentService.addQuestionComment(id, uid, comment));
    }
}
