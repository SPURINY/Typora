package com.calculator.infer;

import org.springframework.stereotype.Component;


public interface Calculator {
    public int add(int i,int j);
    public int minus(int i,int j);
    public int mul(int i,int j);
    public int div(int i,int j);

}
