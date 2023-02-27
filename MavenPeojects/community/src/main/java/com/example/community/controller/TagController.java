package com.example.community.controller;

import com.example.community.entity.Tag;
import com.example.community.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tag")
public class TagController {

    @Autowired
    TagService tagService;

    @PostMapping
    public ResponseEntity addTag(@RequestBody Tag tag){
        return ResponseEntity.ok(tagService.addTag(tag));
    }
}
