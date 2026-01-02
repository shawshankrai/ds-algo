package ds.revision.array;

public class MaximumSumOfContiguousSubArray {
    private static int maximumSumOfContiguousSubArray (int[] array) {
        if(array == null || array.length == 0) return 0;

        int maxSum = array[0];
        int currentSum = array[0];

        for(int i = 1; i < array.length; i++) {
            currentSum = Math.max(array[i], currentSum + array[i]);
            maxSum = Math.max(maxSum,  currentSum);
        }

        return maxSum;
    }
    public static void main(String[] args) {
        int[] input =  new int []{-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maximumSumOfContiguousSubArray(input));// 6
    }
}
