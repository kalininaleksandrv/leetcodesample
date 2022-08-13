package DynamicProgramming;

import java.util.Map;

/**
 * You are climbing a staircase. It takes n steps to reach the top.
 * Each time you can either climb 1 or 2 steps.
 * In how many distinct ways can you climb to the top?
 * Example 2:
 * Input: n = 3
 * Output: 3
 * Explanation: There are three ways to climb to the top.
 * 1. 1 step + 1 step + 1 step
 * 2. 1 step + 2 steps
 * 3. 2 steps + 1 step
 */

public class ClimbingStairs {

    public int climbStairs(int n, Map<Integer, Integer> memo){
        if(n == 1) return 1;
        if(n == 2) return 2;

        if(memo.containsKey(n)) return memo.get(n);
        int temp = climbStairs(n-1, memo)+ climbStairs(n-2, memo);
        memo.put(n, temp);

        return temp;
    }

}
