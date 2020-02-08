package com.klymenko.fibonacciserver.service;

import com.klymenko.fibonacciserver.thrift.Fibonacci;

import java.util.LinkedList;

public class FibonacciHandler implements Fibonacci.Iface {

    public static LinkedList<Long> fibonacci(long n) {
        LinkedList<Long> result = new LinkedList<>();
        if(n < 0) return result;
        long first = 0;
        result.add(first);
        if(n < 1) return result;
        long second = 1;
        result.add(second);

        while(first + second <= n) {
            result.add(first + second);
            long tmp = second;
            second = first + second;
            first = tmp;
        }
        return result;
    }

    public LinkedList<Long> calculate(long data) {
        return fibonacci(data);
    }
}
