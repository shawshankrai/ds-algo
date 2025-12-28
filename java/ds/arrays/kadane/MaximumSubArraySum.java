package ds.arrays.kadane;

public class MaximumSubArraySum {
    private static int maximumSubArraySum(int[] array) {
        // don't initialize with 0, will fail for all negative
        int maxSum = array[0];
        int currentSum = array[0];
        for(int i = 1; i < array.length; i++) {
            currentSum = Math.max(array[i], currentSum + array[i]);
            maxSum = Math.max(maxSum, currentSum);
        }

        return maxSum;
    }

    public static void main(String[] args) {
        int[] array = new int[] {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(maximumSubArraySum(array));

        array = new int[] {-1, -1, -3, -1, -1, -1, -1, -5, -1};
        System.out.println(maximumSubArraySum(array));
    }
}
