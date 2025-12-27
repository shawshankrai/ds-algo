package ds.revision.array;

import java.util.Arrays;

// Running Sum = Prefix Sum where you store every intermediate total
public class RunningSum {
    
    private static int[] runningSum(int[] array) {
        int[] result = new int[array.length];
        int total = 0;

        for(int i = 0; i < array.length; i++) {
            total += array[i];
            result[i] = total;
        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr = {1, 7, 3, 6, 5, 6};
        System.out.println(Arrays.toString(runningSum(arr)));
    }
}