package ds.stack;

import java.util.Stack;

public class LargestRectangleHistogram {

    private static int largestRectangleArea(int[] heights) {
        if(heights == null || heights.length == 0) return 0;

        int maxArea = 0;
        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i <= heights.length; i++) {
            int current = i == heights.length ? 0 : heights[i];
            while(!stack.isEmpty() && current < heights[stack.peek()]) {
                int heightX = stack.pop();

                int width;
                if(!stack.empty()) {
                    width = i - stack.peek() - 1;
                } else {
                    width = i;
                }
                
                maxArea = Math.max(maxArea, heights[heightX] * width);
            }

            stack.push(i);
        }

        return maxArea;
    }
    public static void main(String[] args) {
        System.out.println(largestRectangleArea(new int[]{2,1,5,6,2,3})); // 10
        System.out.println(largestRectangleArea(new int[]{2,4}));       // 4
        System.out.println(largestRectangleArea(new int[]{1}));         // 1
        System.out.println(largestRectangleArea(new int[]{}));          // 0
    }
    
}
