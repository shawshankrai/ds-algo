package arrays.slidingwindow;

public class SumOfKElements {

    private static int sumOfKElements(int[] array, int k) {
        if(array == null || array.length < k) return 0;

        int windowSum = 0;

        for(int i = 0; i < k; i++) {
            windowSum += array[i];
        }

        int maxSum = windowSum;
        int start = 0;

        for(int end = k; end < array.length; end++) {
            // Fixed window = add right, remove left
            windowSum += array[end];
            windowSum -= array[start];
            start++;

            maxSum = Math.max(maxSum, windowSum);
        }

        return maxSum;
    }

    public static void main(String[] args) {
        int[] input = {2,1,5,1,3,2};
        System.out.println(sumOfKElements(input, 3));
    }
}
