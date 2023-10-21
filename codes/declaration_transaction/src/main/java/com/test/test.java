package com.test;

import com.service.BookService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class test {
    ApplicationContext ioc=new ClassPathXmlApplicationContext("ApplicationContext.xml");
    
    @Test
    public void test01(){
        BookService bean = ioc.getBean(BookService.class);
        bean.checkout("ISBN-001","Tom");
    }
}
