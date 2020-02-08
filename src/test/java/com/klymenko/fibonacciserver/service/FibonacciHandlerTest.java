package com.klymenko.fibonacciserver.service;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

public class FibonacciHandlerTest {

    private FibonacciHandler fibonacciHandler;

    @Before
    public void setUp() {
        fibonacciHandler = new FibonacciHandler();
    }

    @Test
    public void testFibonacciNegative() {
        FibonacciHandler fibonacciHandler = new FibonacciHandler();

        Assert.assertEquals(0, fibonacciHandler.calculate(-1).size());
    }

    @Test
    public void testFibonacciFirstValue() {
        FibonacciHandler fibonacciHandler = new FibonacciHandler();

        Assert.assertEquals(1, fibonacciHandler.calculate(0).size());
    }

    @Test
    public void testFibonacciFirstThreeValues() {
        FibonacciHandler fibonacciHandler = new FibonacciHandler();

        Assert.assertEquals(3, fibonacciHandler.calculate(1).size());
    }

    @Test
    public void testFibonacciSequence() {
        List<Long> expectedFibonacciSequence = new LinkedList<Long>() {
            {
                add(0l);
                add(1l);
                add(1l);
                add(2l);
                add(3l);
                add(5l);
                add(8l);
                add(13l);
                add(21l);
                add(34l);
                add(55l);
                add(89l);
                add(144l);
            }
        };
        FibonacciHandler fibonacciHandler = new FibonacciHandler();

        List<Long> actualFibonacciSequence = fibonacciHandler.calculate(200);

        Assert.assertEquals(expectedFibonacciSequence.size(), actualFibonacciSequence.size());

        Assert.assertTrue(actualFibonacciSequence.containsAll(expectedFibonacciSequence));
    }

    @Test
    public void testFibonacciSequenceExactValue() {
        List<Long> expectedFibonacciSequence = new LinkedList<Long>() {
            {
                add(0l);
                add(1l);
                add(1l);
                add(2l);
                add(3l);
                add(5l);
                add(8l);
                add(13l);
                add(21l);
                add(34l);
                add(55l);
                add(89l);
                add(144l);
            }
        };
        FibonacciHandler fibonacciHandler = new FibonacciHandler();

        List<Long> actualFibonacciSequence = fibonacciHandler.calculate(144);

        Assert.assertEquals(expectedFibonacciSequence.size(), actualFibonacciSequence.size());

        Assert.assertTrue(actualFibonacciSequence.containsAll(expectedFibonacciSequence));
    }
}
