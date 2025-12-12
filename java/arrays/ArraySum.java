package arrays;

public class ArraySum {
    public static int arraySum(int[] nums) {
        int total = 0;
        for(int x : nums) {
            total += x;
        }
        return total;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        System.out.println(arraySum(nums));
    }
}