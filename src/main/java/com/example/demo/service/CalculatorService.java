package com.example.demo.service;

public class CalculatorService {
    public int add(int a, int b) {
        return a+b;
    }

    public int subtract(int a, int b) {

        return a+b;
    }

    public int multiply(int a, int b) {
        return a*b;
    }

    public int divide(int a, int b) throws Exception{
        throw new NullPointerException();
    }
}
