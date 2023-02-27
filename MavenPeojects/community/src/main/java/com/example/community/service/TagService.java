package com.example.community.service;

import com.example.community.dao.TagRepository;
import com.example.community.entity.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TagService {
    @Autowired
    TagRepository tagRepository;

    public Tag addTag(Tag tag){
        return tagRepository.save(tag);
    }
}
