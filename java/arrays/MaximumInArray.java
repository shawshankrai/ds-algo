package arrays;

public class MaximumInArray {

    public static int maximumInArray(int[] array) {
        int max = Integer.MIN_VALUE;
        for(int x : array) {
            if(x > max) max = x;
        }

        return max;
    }
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5}; 
        int result = maximumInArray(array);
        System.out.println(result);
        
    }
}
