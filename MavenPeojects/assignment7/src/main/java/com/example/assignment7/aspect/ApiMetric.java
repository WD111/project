package com.example.assignment7.aspect;

import lombok.Data;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@Data
public class ApiMetric {
    int minTime = 0;
    int maxTime = 0;
    int count = 0;
    int totalTime = 0;
    Map<String, Integer> countMap = Collections.synchronizedMap(new HashMap<>());

    public void addTime(int time){
        totalTime +=time;
        count++;
        if(time>maxTime){
            maxTime=time;
        }else if(time<minTime){
            minTime=time;
        }
    }

    public void addException(Throwable e){
        String exceptionName = e.getClass().getName();
        Integer base = countMap.get(exceptionName);
        countMap.put(exceptionName,base==null?1:base+1);
    }

    @Override
    public String toString() {
        StringBuilder builder=new StringBuilder();
        builder.append("ExecutionCount:"+count+"\n");
        builder.append("TotalExecutionTime:"+totalTime+"\n");
        builder.append("AverageExecutionTime:"+(float)totalTime/count+"\n");
        builder.append("MinExecutionTime:"+minTime+"\n");
        builder.append("MaxExecutionTime:"+maxTime+"\n");
        builder.append("ExceptionCounts:\n");
        countMap.forEach((e,count)->{
            builder.append(" "+e+":"+count+"\n");
        });
        return builder.toString();
    }
}
