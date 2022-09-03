package DynamicProgramming;

import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class FibonacciNumbersTest {

    @Test
    void getNFibonacciNumberV1() {
        FibonacciNumbers fibonacciNumbers = new FibonacciNumbers();
        assertEquals(0, fibonacciNumbers.getNFibonacciNumberV1(0));
        assertEquals(1, fibonacciNumbers.getNFibonacciNumberV1(2));
        long start = System.nanoTime();
        assertEquals(102334155, fibonacciNumbers.getNFibonacciNumberV1(40));
        long finish = System.nanoTime();
        System.out.println("it takes " + (finish-start)/1000000 + " ms");
    }

    @Test
    void getNFibonacciNumberV2() {
        FibonacciNumbers fibonacciNumbers = new FibonacciNumbers();
        assertEquals(0, fibonacciNumbers.getNFibonacciNumberV2(0, new HashMap<>()));
        assertEquals(1, fibonacciNumbers.getNFibonacciNumberV2(2, new HashMap<>()));
        long start = System.nanoTime();
        assertEquals(102334155, fibonacciNumbers.getNFibonacciNumberV2(40, new HashMap<>()));
        long finish = System.nanoTime();
        System.out.println("it takes " + (finish-start)/1000000 + " ms");
    }

    @Test
    void getNFibonacciNumberV3() {
        FibonacciNumbers fibonacciNumbers = new FibonacciNumbers();
        assertEquals(0, fibonacciNumbers.getNFibonacciNumberV3(0));
        assertEquals(1, fibonacciNumbers.getNFibonacciNumberV3(2));
        long start = System.nanoTime();
        assertEquals(102334155, fibonacciNumbers.getNFibonacciNumberV3(40));
        long finish = System.nanoTime();
        System.out.println("it takes " + (finish-start)/1000000 + " ms");
    }


    @Test
    void getFibonacciNumbersV4() {
        FibonacciNumbers fibonacciNumbers = new FibonacciNumbers();
        assertEquals(0, fibonacciNumbers.getFibonacciNumbersV4(0, new int[]{0, 1}));
        assertEquals(1, fibonacciNumbers.getFibonacciNumbersV4(2, new int[]{0, 1}));
        long start = System.nanoTime();
        assertEquals(102334155, fibonacciNumbers.getFibonacciNumbersV4(40, new int[]{0, 1}));
        long finish = System.nanoTime();
        System.out.println("it takes " + (finish-start)/1000000 + " ms");
    }
}