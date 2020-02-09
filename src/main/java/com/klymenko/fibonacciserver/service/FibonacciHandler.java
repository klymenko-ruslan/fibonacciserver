package com.klymenko.fibonacciserver.service;

import com.klymenko.fibonacciserver.thrift.Fibonacci;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class FibonacciHandler implements Fibonacci.Iface {

    private long prev = 0l;
    private long current = 1l;
    private LinkedList<Long> cachedResults = new LinkedList<Long>() {
        {
            add(prev);
            add(current);
        }
    };

    public List<Long> fibonacci(long n) {
        if(n < 0) return Collections.EMPTY_LIST;
        if(n < 1) return cachedResults.subList(0, 1);

        if(prev + current > n) {
            int cnt = 1;
            Long localPrev = null;
            for(Long value: cachedResults) {
                if(localPrev == null) {
                    localPrev = value;
                    continue;
                }
                cnt++;
                if(localPrev + value > n) {
                    return cachedResults.subList(0, cnt);
                }
                localPrev = value;
            }
        }

        while(prev + current <= n) {
            cachedResults.add(prev + current);
            long tmp = current;
            current = prev + current;
            prev = tmp;
        }
        return cachedResults;
    }

    public List<Long> calculate(long data) {
        return fibonacci(data);
    }
}
