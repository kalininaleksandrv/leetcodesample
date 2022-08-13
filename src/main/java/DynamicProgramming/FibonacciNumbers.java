package DynamicProgramming;

import java.util.Map;

public class FibonacciNumbers {

    /**
     * naive version
     * O(2^n) two to the n
     */
    public long getNFibonacciNumberV1(int n){
        if(n < 1) throw  new RuntimeException("n must be >= 1");
        if(n == 1) return 0;
        if(n <= 3) return 1;

        return getNFibonacciNumberV1(n-1) + getNFibonacciNumberV1(n-2);
    }

    /**
     * add memoization to reduce complexity
     * 0(n) version with dynamic programing technique
     */
    public long getNFibonacciNumberV2(int n, Map<Integer, Long> memo){

        if(n < 1) throw  new RuntimeException("n must be >= 1");
        if(n == 1) return 0;
        if(n <= 3) return 1;

        long temp;
        if(!memo.containsKey(n)){
            temp = getNFibonacciNumberV2(n-1, memo)+getNFibonacciNumberV2(n-2, memo);
            memo.put(n, temp);
        } else {
            return memo.get(n);
        }
        return temp;
    }

    /**
     * O(n) without dynamic programming
     */
    public long getNFibonacciNumberV3(int n){

        if(n < 1) throw  new RuntimeException("n must be >= 1");
        if(n == 1) return 0;
        if(n <= 3) return 1;

        long temp = 0;
        long stepMinusOne = 1;
        long stepMinusTwo = 1;

        for (int j = 4; j <= n; j++) {
            temp = stepMinusOne+stepMinusTwo;
            stepMinusTwo = stepMinusOne;
            stepMinusOne = temp;
        }
        return temp;
    }

}
