package com.calculator.impl;

import com.calculator.infer.Calculator;
import org.springframework.stereotype.Service;


public class MyCal implements Calculator {

    public int add(int i, int j) {
        int result=i+j;
        return result;
    }


    public int minus(int i, int j) {
        return i-j;
    }

    public int mul(int i, int j) {
        return i*j;
    }

    public int div(int i, int j) {
        return i/j;
    }
}
