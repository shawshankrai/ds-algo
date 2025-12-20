package ds.stack;

import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElementRight {

    private static int[] nextGreater(int[] nums) {
        if(nums == null || nums.length == 0) return new int[0];
        
        int[] res = new int[nums.length];
        Arrays.fill(res, -1);

        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < nums.length; i++) {
            while(!stack.isEmpty() && nums[i] > nums[stack.peek()]) {
                int idx = stack.pop();
                res[idx] = nums[i];
            }

            stack.push(i);

        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(nextGreater(new int[]{4, 5, 2, 25})));
        System.out.println(Arrays.toString(nextGreater(new int[]{13, 7, 6, 12})));
    }
}
