package DynamicProgramming;

public class CanSum {

    /**
     * is it possible to achieve target if sum every given digit from array, every digit can be used many times
     */

    public boolean isSum (int target, int[] numbers) {
        if(target == 0) return true;
        if(target<0) return false;
        for (int num:numbers) {
            boolean sum = isSum(target - num, numbers);
            if(sum) return true;
        }
        return false;
    }
}
