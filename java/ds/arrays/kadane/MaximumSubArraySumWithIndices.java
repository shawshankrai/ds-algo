package ds.arrays.kadane;

import java.util.Arrays;

public class MaximumSubArraySumWithIndices {

    private static int[] maxSubArrayWithIndices(int[] array) {
        if(array == null || array.length == 0) return new int[] {0, -1, -1};

        int maxSum = array[0];
        int currentSum = array[0];

        int bestStart = 0;
        int bestEnd = 0;
        int tempStart = 0;

        for(int i = 1; i < array.length; i++) {
            if(array[i] > currentSum + array[i]) { // which is greater new start or old state
                currentSum = array[i];
                tempStart = i; // track new current start
            } else {
                currentSum = currentSum + array[i];
            }

            if(currentSum > maxSum) {
                maxSum = currentSum;
                bestStart = tempStart;
                bestEnd = i;
            }
        }

        return new int[] {maxSum, bestStart, bestEnd};
    }
    public static void main(String[] args) {
        int[] array = {-2, 1, -3, 4, -1, 2, 1, -5, 4};

        int[] ans = maxSubArrayWithIndices(array);
        System.out.println("maxSum = " + ans[0]);
        System.out.println("start = " + ans[1] + ", end = " + ans[2]);
        System.out.println("subarray = " + Arrays.toString(Arrays.copyOfRange(array, ans[1], ans[2] + 1)));
        // Expected: maxSum=6, start=3, end=6, subarray=[4, -1, 2, 1]
    }
    
}
