package Arrays;

import java.util.HashMap;
import java.util.Map;

public class PairWithSumEqualGivenDigit {

    /**
     * given an array and target digits
     * let's find a pair of digits in array, which sum equals given target
     * Example
     * Input: nums = [3,2,4], target = 6
     * Output: [1,2]
     */
    public boolean hasPairWithSumEqualsGivenDigitVer1(int[] intArray, int target){

        /**
         * for every digit try to understand "pretender" - what digit could be if we subtract target minus current digit
         * after we understand pretender, we must try to find it in a map (constant time)
         * if success - our pair founded
         * first - lets create a map which key will be current index of element and value - element itself
         */

        Map<Integer, Integer> numsMap = new HashMap<>();
        for (int e = 0; e < intArray.length; e++){
            numsMap.put(intArray[e], e);
        }

        /**
         * here main algorithm describing above
         */

        for (int i = 0; i < intArray.length; i++ ) {
            int second = intArray[i];
            int pretender = target - second;
            if(numsMap.containsKey(pretender) && numsMap.get(pretender)!=i) {
                return true;
            }
        }
        return false;
    }
}
