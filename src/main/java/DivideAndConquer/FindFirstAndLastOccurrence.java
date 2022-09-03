package DivideAndConquer;

public class FindFirstAndLastOccurrence {
    /*
    given sorted array, the goal is to find first and last position of given number
    [1,2,3,3,3,4], 3 returns 2,4
     */

    int[] getFirstAndLastOcc (int[] nums, int target) {
        if(nums.length == 0) return new int[]{-1, -1};
        if(nums.length == 1) return new int[]{nums[0], nums[0]};

        return new int[] {getFirst(nums, target), getLast(nums, target)};
    }


    private int getFirst(int[] nums, int target) {
        if(nums[0] == target && nums[1] == target) return 0;
        int left = 0;
        int right = nums.length-1;
        while (left<=right){
            if (left == 0 && right == 0) return -1;
            int mid = Math.max((left+right)/2, 1);
            if(nums[mid] == target && nums[mid-1]<target){
                return mid;
            } else if (nums[mid]<target) {
                left = mid+1;
            } else {
                right = mid-1;
            }
        }
        return -1;
    }

    private int getLast(int[] nums, int target) {
        if (nums[nums.length - 1] == target && nums[nums.length-2] == target) return nums.length-1;
        int left = 0;
        int right = nums.length-1;
        while (left<=right){
            if (left == 0 && right == 0) return -1;
            int mid = Math.max((left+right)/2, 1);
            if(nums[mid] == target && (mid+1>=nums.length-1 || nums[mid+1]>target)){
                return mid;
            } else if (nums[mid] > target) {
                right = mid-1;
            } else {
                left = mid+1;
            }
        }
        return -1;
    }
}
