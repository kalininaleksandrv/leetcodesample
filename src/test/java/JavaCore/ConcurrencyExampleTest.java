package JavaCore;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ConcurrencyExampleTest {

    @Test
    void exampleOfSync() {
        ConcurrencyExample concurrencyExample = new ConcurrencyExample();
        int res = concurrencyExample.exampleOfSync();
        assertEquals(1, res);
    }

    @Test
    void howToCreateThreads() {
        ConcurrencyExample concurrencyExample = new ConcurrencyExample();
        //simply run method, see the result in console
        concurrencyExample.howToCreateThreads();
    }

    @Test
    void calculationInDifferentThreadWithCallable() {
        ConcurrencyExample concurrencyExample = new ConcurrencyExample();
        int res = concurrencyExample.calculationInDifferentThreadWithCallable(new int[]{1, 2, 3});
        // see the thread usage in console
        assertEquals(6, res);
    }

    @Test
    void callableCalculatorLambdaSimplification() {
        ConcurrencyExample concurrencyExample = new ConcurrencyExample();
        int res = concurrencyExample.callableCalculatorLambdaSimplification(new int[]{1,2,3});
        // see the thread usage in console
        assertEquals(6, res);
    }

    @Test
    void executorWithoutService() {
        ConcurrencyExample concurrencyExample = new ConcurrencyExample();
        //simply run method, see the result in console
        concurrencyExample.executorWithoutService();
    }

    @Test
    void executorServiceWithCallableUsage() {
        ConcurrencyExample concurrencyExample = new ConcurrencyExample();
        // see the thread usage in console
        int res = concurrencyExample.executorServiceWithCallableUsage(new int[]{1, 2, 3});
        assertEquals(6, res);
    }
}