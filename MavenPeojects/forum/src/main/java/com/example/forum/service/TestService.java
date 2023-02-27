package com.example.forum.service;

import com.example.forum.common.Answer;
import com.example.forum.common.ExecUtil;
import org.springframework.stereotype.Service;

import java.io.FileWriter;
import java.io.IOException;

@Service
public class TestService {
    public Answer run(String code){
        String DIR = "E:/javaTest/";
        String javaFile = DIR + "Main.java";
        String javaClass = "Main";

        String compileCmd = String.format("javac -encoding utf8 %s -d %s", javaFile, DIR);
        String runningCmd = String.format("java -classpath %s %s", DIR, javaClass);
        FileWriter writer = null;
        try{
            writer = new FileWriter(javaFile);
            writer.write(code);
            writer.close();
        } catch (IOException e){
            e.printStackTrace();
            return null;
        }
        Answer answer = ExecUtil.run(compileCmd, false, true);
        System.out.println(answer.getStderr());
        if(answer.getError() == 0){
            answer = ExecUtil.run(runningCmd, true, true);
            if(answer.getError() == 0){
                answer.setReason(Answer.SUCCESS);
            } else {
                answer.setReason(Answer.RunTimeError);
            }
            System.out.println(answer.getStdout());
        } else {
            answer.setReason(Answer.ERROR);
        }
        return answer;
    }

    public Answer CRun(String Code){
        String DIR = "E:/javaTest/";
        String CFile = DIR + "main.c";
        String CExe = "main";
        String compileCmd = String.format("gcc %s -o %s", CFile, CExe);
        String runningCmd = String.format("%s", CExe);
        FileWriter fileWriter = null;
        try{
            fileWriter = new FileWriter(CFile);
            fileWriter.write(Code);
            fileWriter.close();
        } catch (IOException e){
            e.printStackTrace();
        }
        Answer answer = ExecUtil.run(compileCmd, false, true);
        System.out.println(answer.getStderr());
        if(answer.getError() == 0){
            answer = ExecUtil.run(runningCmd, true, true);
            if(answer.getError() == 0){
                answer.setReason(Answer.SUCCESS);
            } else {
                answer.setReason(Answer.RunTimeError);
            }
            System.out.println(answer.getStdout());
        } else {
            answer.setReason(Answer.ERROR);
        }
        return answer;
    }

    public Answer CRun(String Code, String arg){
        String DIR = "E:/javaTest/";
        String CFile = DIR + "main++.cpp";
        String CExe = "main++";
        String compileCmd = String.format("g++ %s -o %s", CFile, CExe);
        String runningCmd = String.format("%s", CExe);
        String cinCmd = String.format("%s", arg);
        FileWriter fileWriter = null;
        try{
            fileWriter = new FileWriter(CFile);
            fileWriter.write(Code);
            fileWriter.close();
        } catch (IOException e){
            e.printStackTrace();
        }
        Answer answer = ExecUtil.run(compileCmd, false, true);
        System.out.println(answer.getStderr());
        if(answer.getError() == 0){
            answer = ExecUtil.run(runningCmd, true, true);
            if(answer.getError() == 0){
                answer = ExecUtil.run(cinCmd, true, true);
                answer.setReason(Answer.SUCCESS);
            } else {
                answer.setReason(Answer.RunTimeError);
            }
            System.out.println(answer.getStdout());
        } else {
            answer.setReason(Answer.ERROR);
        }
        return answer;
    }
}
