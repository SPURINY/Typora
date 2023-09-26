package com.calculator.utils;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

@Aspect
@EnableAspectJAutoProxy // 启用Spring的AOP功能
@Component
public class validateAspect {

    @Pointcut("execution(public int com.calculator.impl.MyCal.*(int,int))")
    public void chongyong(){}



    @Before("chongyong()")
    public static void logStart(JoinPoint jp){
        String name=jp.getSignature().getName();
        System.out.println("[validate]"+name+"方法开始执行");
    }
    @After("chongyong()")
    public static void logEnd(JoinPoint jp){
        String name=jp.getSignature().getName();
        System.out.println("[validate]"+name+"方法结束");
    }
    @AfterReturning(value="chongyong()",returning = "result")
    public static void logReturn(JoinPoint jp,Object result){
        String name=jp.getSignature().getName();
        System.out.println("[validate]"+name+"方法正常返回,结果是"+result);
    }
    @AfterThrowing(value="execution(public int com.calculator.impl.MyCal.*(int,int))",throwing="exception")
    public static void logException(JoinPoint jp,Exception exception){
        String name=jp.getSignature().getName();
        System.out.println("[validate]"+name+"方法异常:"+exception);
    }
}
