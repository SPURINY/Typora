package com.calculator.impl;

import com.calculator.infer.Calculator;
import org.springframework.stereotype.Service;

@Service
public class MyCal implements Calculator {
    @Override
    public int add(int i, int j) {
        int result=i+j;
        return result;
    }

    @Override
    public int minus(int i, int j) {
        return i-j;
    }

    @Override
    public int mul(int i, int j) {
        return i*j;
    }

    @Override
    public int div(int i, int j) {
        return i/j;
    }
}
