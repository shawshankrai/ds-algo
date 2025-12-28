package ds.arrays.kadane;

public class MaximumSumCircularSubArray {
    private static int maximumSumCircularSubArray(int[] array) {
        if(array  == null || array.length == 0) return 0;

        int totalSum = array[0];
        int minSum = array[0];
        int currentSumMin = array[0];
        int maxSum = array[0];
        int currentSumMax = array[0];


        for(int i = 1; i < array.length; i++) {
            totalSum += array[i];
            
            // min kadane
            currentSumMin = Math.min(array[i], currentSumMin + array[i]);
            minSum = Math.min(minSum, currentSumMin);

            // max kadane
            currentSumMax = Math.max(array[i], currentSumMax + array[i]);
            maxSum = Math.max(maxSum, currentSumMax);
        }

        // max circular sum
        int wrapSum = totalSum - minSum;

        // check, wether circular sum or max sum is bigger
        return maxSum < 0 ? maxSum : Math.max(maxSum, wrapSum);
    }

    public static void main(String[] args) {
        System.out.println(maximumSumCircularSubArray(new int[] {1, -2, 3, -2}));
        System.out.println(maximumSumCircularSubArray(new int[] {5, -3, 5}));
        System.out.println(maximumSumCircularSubArray(new int[] {-3, -2, -3}));
    }
}
