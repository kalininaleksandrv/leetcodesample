package DivideAndConquer;

public class FindMaxInUnimodalArray {
    /**
     * given array is increasing and then decreasing
     * find maximum means find the point when number on both side of point is smaller
     * corner cases is when array is sorted
     */
    int getMaxFromArray(int[] arr) {
        if (arr.length == 0) return -1;
        if (arr.length == 1) return arr[0];
        if (arr.length == 2) return Math.max(arr[0], arr[1]);
        //first lets find a middle of array and see what's happen left and right to this point
        int mid = Math.max(1, arr.length/2);
        if(arr[mid]>arr[mid+1] && arr[mid]>arr[mid-1]) return arr[mid]; //check if max has been found
        int[] half = new int[arr.length-mid]; //then create a half of array and copy left or right half to it
        if(arr[mid]<arr[mid+1]){
//            System.arraycopy(arr, mid, half, 0, half.length); //equal of loop

            for (int i = 0; i < half.length; i++) {
                half[i] = arr[i+mid];
            }

        } else {
//            System.arraycopy(arr, 0, half, 0, half.length); //equal of loop

            for (int i = 0; i < half.length; i++) {
                half[i] = arr[i];
            }
        }
        //recursively call method with remaining half - divide and conquer strategy
        return getMaxFromArray(half);
    }
}
