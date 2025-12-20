package java.ds.arrays.twopointer;

public class TwoSumSorted {
    
    public static int[] twoSum(int[] array, int target) {
        if(array == null || array.length == 0) return new int[] {0, 0};

        int left = 0;
        int right = array.length - 1;
        while(left < right) {
            int sum = array[left] + array[right];
            
            if(sum == target) {
                return new int[] {left + 1, right + 1};
            } else if(sum < target) {
                left ++;
            } else if(sum > target) {
                right --;
            }

        }

        return new int[] {-1, -1};
    }
    public static void main(String[] args) {
        int[] input = {2, 7, 11, 15};
        for(int x : twoSum(input, 9)) {
            System.out.println(x);
        }
    }
}
