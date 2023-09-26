package com.lab;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
/*
2	通过类型获取bean
从IOC容器中获取bean时，除了通过id值获取，还可以通过bean的类型获取。
但如果同一个类型的bean在XML文件中配置了多个，则获取时会抛出异常，所以同一个类型的bean在容器中必须是唯一的。
HelloWorld helloWorld = cxt.getBean(HelloWorld. class);
  <bean id="p1" class="com.lab2.Person"></bean>
    <bean id="p1" class="com.lab2.Person"></bean>
* */
public class Main {
    public static void main(String[] args) {

        ApplicationContext ctx=new ClassPathXmlApplicationContext("spring.xml");
        Person p=(Person)ctx.getBean("lab12");
        p.run();
    }
}