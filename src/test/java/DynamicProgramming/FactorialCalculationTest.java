package DynamicProgramming;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FactorialCalculationTest {

    @Test
    void getFactorial() {
        FactorialCalculation factorialCalculation = new FactorialCalculation();
        int res = factorialCalculation.getFactorial(4);
        assertEquals(24, res);
    }

    @Test
    void getFactorialTailRecursion() {
        FactorialCalculation factorialCalculation = new FactorialCalculation();
        int res = factorialCalculation.getFactorialTailRecursion(4, 1);
        assertEquals(24, res);
    }
}