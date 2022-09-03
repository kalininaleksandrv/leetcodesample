package DynamicProgramming;

public class FactorialCalculation {

    public int getFactorial(int i) {
        if(i==1) return 1;
        return i * getFactorial(i -1);
    }

    public int getFactorialTailRecursion (int input, int accumulator) {
        if (input == 1) return accumulator;
        return getFactorialTailRecursion(input-1, accumulator*input);
    }
}
