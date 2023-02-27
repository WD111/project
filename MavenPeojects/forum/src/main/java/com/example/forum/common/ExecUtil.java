package com.example.forum.common;

import java.io.*;

public class ExecUtil {
    private ExecUtil(){}

    public static Answer run(String cmd, Boolean stdoutB, Boolean stderrB){
        Answer answer = new Answer();
        try{
            Process process = Runtime.getRuntime().exec(cmd);
            String line = "";
            String re = "";
            String stdout = "";
            if(stdoutB){
                BufferedReader stdoutForm = new BufferedReader(new InputStreamReader(process.getInputStream(), "GBK"));
                while((line = stdoutForm.readLine()) != null){
                    stdout += line + "\n";
                }
                stdoutForm.close();
            }
            if(stderrB){
                BufferedReader stdoutForm = new BufferedReader(new InputStreamReader(process.getErrorStream(), "GBK"));
                while((line = stdoutForm.readLine())!=null){
                    re += line + "\n";
                }
                stdoutForm.close();
            }
            int exitCode = process.waitFor();
            answer.setError(exitCode);
            answer.setStderr(re);
            answer.setStdout(stdout);
            return answer;
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        answer.setError(2);
        return answer;
    }
}
