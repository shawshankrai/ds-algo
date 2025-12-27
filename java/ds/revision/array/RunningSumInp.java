package ds.revision.array;

import java.util.Arrays;

// Running Sum = Prefix Sum where you store every intermediate total
public class RunningSumInp {
    
    private static int[] runningSumOne(int[] array) {
        int total = 0;
        for(int i = 0; i < array.length; i++ ) {
            total += array[i];
            array[i] = total;
        }

        return array;
    }

    private static int[] runningSumTwo(int[] array) {
        for(int i = 1; i < array.length; i++ ) {
            array[i] += array[i - 1] ;
        }

        return array;
    }

    public static void main(String[] args) {
        int[] arrOne = {1, 7, 3, 6, 5, 6};
        int[] arrTwo = {1, 7, 3, 6, 5, 6};
        System.out.println(Arrays.toString(runningSumOne(arrOne)));
        System.out.println(Arrays.toString(runningSumTwo(arrTwo)));
    }
}