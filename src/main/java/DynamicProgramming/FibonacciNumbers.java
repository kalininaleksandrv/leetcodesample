package DynamicProgramming;

import java.util.Map;

public class FibonacciNumbers {

    /*
     * naive version
     * O(2^n) two to the n
     */
    public long getNFibonacciNumberV1(int n){
        if(n == 0) return 0;
        if(n == 1) return 1;
        return getNFibonacciNumberV1(n-1) + getNFibonacciNumberV1(n-2);
    }

    /*
     * add memoization to reduce complexity
     * 0(n) version with dynamic programing technique
     */
    public long getNFibonacciNumberV2(int n, Map<Integer, Long> memo){

        if(n == 0) return 0;
        if(n == 1) return 1;

        long temp;
        if(!memo.containsKey(n)){
            temp = getNFibonacciNumberV2(n-1, memo)+getNFibonacciNumberV2(n-2, memo);
            memo.put(n, temp);
        } else {
            return memo.get(n);
        }
        return temp;
    }

    /*
     * O(n) without dynamic programming
     */
    public long getNFibonacciNumberV3(int n){

        if(n == 0) return 0;
        if(n < 3) return 1;

        long temp = 0;
        long stepMinusOne = 1;
        long stepMinusTwo = 1;

        for (int j = 3; j <= n; j++) {
            temp = stepMinusOne+stepMinusTwo;
            stepMinusTwo = stepMinusOne;
            stepMinusOne = temp;
        }
        return temp;
    }

    /*
     * tail recursion variant
     * in a tail recursion you don't need to wait previous call to invoke the next
     * because there is no operation which performs on a recursion call
     * f.e. (getNFibonacciNumberV1(n-1) + getNFibonacciNumberV1(n-2)) - here is the sum operation,
     * so we must wait result until next step
     * it ends up to deeeeeep stack of calls
     * meantime tail recursion function call next step after previous iterative
     * and compiler translate it to ordinary while loop
     */

    public long getFibonacciNumbersV4(int input, int[] accumulator) {
        if(input==0) return accumulator[0];
        if(input==1) return accumulator[1];
        return getFibonacciNumbersV4(input-1, new int[]{accumulator[1], accumulator[0]+accumulator[1]});
    }

}
