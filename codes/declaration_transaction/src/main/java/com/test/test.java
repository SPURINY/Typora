package com.test;

import com.service.BookService;
import com.service.MulService;
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

    @Test
    public void test02(){
        BookService bean = ioc.getBean(BookService.class);
        //System.out.println("ISBN-001单价"+bean.getPrice("ISBN-001"));
        System.out.println(bean.getClass());
    }
    @Test
    public void test03(){
        MulService bean = ioc.getBean(MulService.class);
        bean.mulTx();

    }
}
