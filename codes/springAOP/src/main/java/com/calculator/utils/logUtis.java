package com.calculator.utils;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;
@Aspect
@EnableAspectJAutoProxy // 启用Spring的AOP功能
@Component
public class logUtis {

    @Pointcut("execution(public int com.calculator.impl.MyCal.*(int,int))")
    public void chongyong(){}

    //@Around("chongyong()")
    public Object myAround(ProceedingJoinPoint pjp) throws Throwable {
        Object[] args = pjp.getArgs();//获取目标方法参数
        String name=pjp.getSignature().getName();//获取方法签名对象，通过签名对象获取方法名
        Object proceed = null;
        try{
            //@Before
            System.out.println(name+"方法开始执行【环绕】");
            proceed=pjp.proceed(args);//相当于目标方法的执行语句
            //@AfterReturning
            System.out.println(name+"方法正常返回【环绕】");

        }catch(Exception e){
            //@AfterThrowing
            System.out.println(name+"方法异常【环绕】:"+e);
        }finally{
            //@After()
            System.out.println(name+"方法结束【环绕】");
        }

        return proceed;
    }

    @Before("chongyong()")
    public static void logStart(JoinPoint jp){
        String name=jp.getSignature().getName();
        System.out.println(name+"方法开始执行");
    }
    @After("chongyong()")
    public static void logEnd(JoinPoint jp){
        String name=jp.getSignature().getName();
        System.out.println(name+"方法结束");
    }
    @AfterReturning(value="chongyong()",returning = "result")
    public static void logReturn(JoinPoint jp,Object result){
        String name=jp.getSignature().getName();
        System.out.println(name+"方法正常返回,结果是"+result);
    }
    @AfterThrowing(value="execution(public int com.calculator.impl.MyCal.*(int,int))",throwing="exception")
    public static void logException(JoinPoint jp,Exception exception){
        String name=jp.getSignature().getName();
        System.out.println(name+"方法异常:"+exception);
    }
}
