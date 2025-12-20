package ds.arrays.slidingwindow;

public class SmallestSubArraySum {
    private static int smallestSubArraySum(int[] array, int s) {
        if(array == null || array.length == 0) return 0;

        int windowSum = 0;
        int start = 0;
        int minLength = Integer.MAX_VALUE;
        
        // In variable sliding window problems, we expand to meet the condition and shrink to optimize the result
        for(int end = 0; end < array.length; end++) {
            windowSum += array[end];
            
            while(windowSum >= s) {
                minLength = Math.min(minLength, end - start + 1);
                windowSum -= array[start];
                start ++;
            } 
        }

        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }

    public static void main(String[] args) {
        int[] input = {2,1,5,2,3,2};
        System.out.println(smallestSubArraySum(input, 7));
    }
}
