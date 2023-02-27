package com.example.forum.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.forum.common.Answer;
import com.example.forum.service.TestService;
import com.fasterxml.jackson.databind.util.JSONPObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/code", produces = "application/json")
public class TestController {
    @Autowired
    TestService testService;

    @RequestMapping(value = "/run")
    public String run(@RequestBody JSONObject jsonObject){
        Answer answer = testService.run(jsonObject.getString("code"));
        if(answer == null){
            return "IO Error";
        } else {
            return JSONObject.toJSONString(answer);
        }
    }

    @RequestMapping(value = "/CRun")
    public String CRun(@RequestBody JSONObject jsonObject){
        Answer answer = testService.CRun(jsonObject.getString("code"), jsonObject.getString("arg"));
        if(answer == null){
            return "IO Error";
        } else {
            return JSONObject.toJSONString(answer);
        }
    }
}
