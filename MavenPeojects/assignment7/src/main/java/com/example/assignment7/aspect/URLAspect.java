package com.example.assignment7.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.Calendar;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@Aspect
@Component
public class URLAspect {

    Map<String, ApiMetric> metrics = Collections.synchronizedMap(new HashMap<>());

    @Around("@within(org.springframework.web.bind.annotation.RestController)")
    public Object doProfiling(ProceedingJoinPoint joinPoint) throws Throwable {
        String method=joinPoint.getSignature().toString();
        ApiMetric apiMetric= metrics.get(method);
        if(apiMetric == null){
            apiMetric = new ApiMetric();
            metrics.put(method,apiMetric);
        }
        try {
            long t1= Calendar.getInstance().getTimeInMillis();
            Object result = joinPoint.proceed();
            long t2= Calendar.getInstance().getTimeInMillis();
            apiMetric.addTime((int)(t2-t1));
            return result;
        } catch (Throwable e) {
            apiMetric.addException(e);
            throw e;
        }
    }

    public Map<String, ApiMetric> getMetrics() {
        return metrics;
    }
}
