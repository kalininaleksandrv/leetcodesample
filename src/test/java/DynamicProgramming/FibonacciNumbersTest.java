package DynamicProgramming;

import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class FibonacciNumbersTest {

    @Test
    void getNFibonacciNumberV1() {
        FibonacciNumbers fibonacciNumbers = new FibonacciNumbers();
        assertEquals(0, fibonacciNumbers.getNFibonacciNumberV1(1));
        assertEquals(1, fibonacciNumbers.getNFibonacciNumberV1(3));
        long start = System.nanoTime();
        assertEquals(63245986, fibonacciNumbers.getNFibonacciNumberV1(40));
        long finish = System.nanoTime();
        System.out.println("it takes " + (finish-start)/1000000 + " ms");
    }

    @Test
    void getNFibonacciNumberV2() {
        FibonacciNumbers fibonacciNumbers = new FibonacciNumbers();
        assertEquals(0, fibonacciNumbers.getNFibonacciNumberV2(1, new HashMap<>()));
        assertEquals(1, fibonacciNumbers.getNFibonacciNumberV2(3, new HashMap<>()));
        long start = System.nanoTime();
        assertEquals(63245986, fibonacciNumbers.getNFibonacciNumberV2(40, new HashMap<>()));
        long finish = System.nanoTime();
        System.out.println("it takes " + (finish-start)/1000000 + " ms");
    }
}