package DynamicProgramming;

import java.util.Map;

public class CanSum {

    /**
     * is it possible to achieve target if sum every given digit from array, every digit can be used many times
     */

    public boolean isSum (Integer target, int[] numbers, Map<Integer, Boolean> memo) {
        if(memo.containsKey(target)) return memo.get(target);
        if(target == 0) return true;
        if(target<0) return false;
        for (int num:numbers) {
            boolean res = isSum(target - num, numbers, memo);
            memo.put(num, res);
            if(res) return true;
        }
        memo.put(target, false);
        return false;
    }
}
