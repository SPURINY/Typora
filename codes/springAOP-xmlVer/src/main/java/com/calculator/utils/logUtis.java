package com.calculator.utils;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

public class logUtis {

    public static void logStart(JoinPoint jp){
        String name=jp.getSignature().getName();
        System.out.println(name+"方法开始执行");
    }

    public static void logEnd(JoinPoint jp){
        String name=jp.getSignature().getName();
        System.out.println(name+"方法结束");
    }

    public static void logReturn(JoinPoint jp,Object result){
        String name=jp.getSignature().getName();
        System.out.println(name+"方法正常返回,结果是"+result);
    }

    public static void logException(JoinPoint jp,Exception exception){
        String name=jp.getSignature().getName();
        System.out.println(name+"方法异常:"+exception);
    }
}
