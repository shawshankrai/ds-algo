package ds.stack;

import java.util.Stack;

public class TrappingRainWaterStack {

    private static int trap(int[] heights) {
        // Edge case: no bars, no water
        if (heights == null || heights.length == 0) return 0;

        int water = 0;                     // total trapped water
        Stack<Integer> stack = new Stack<>(); // stores indices of bars (monotonic decreasing)

        // Traverse each bar
        for (int i = 0; i < heights.length; i++) {

            // While current bar is taller than the bar at stack top,
            // we have found a right boundary for a "valley"
            while (!stack.isEmpty() && heights[i] > heights[stack.peek()]) {

                // Pop the valley bottom
                int bottom = stack.pop();

                // If stack becomes empty, no left boundary exists
                // so water cannot be trapped
                if (stack.isEmpty()) break;

                // Left boundary is now at the new stack top
                int left = stack.peek();

                // Right boundary is the current index
                int right = i;

                // Width between the two boundaries
                // (excluding both left and right bars)
                // Bars that can hold water are between (left + 1) and (right - 1)
                // Window calc = r - l + 1
                // width = (right - 1) - (left + 1) + 1 
                //       = right - left - 1
                int width = right - left - 1;

                // Height of water is limited by the shorter boundary
                // minus the height of the bottom
                int boundedHeight =
                        Math.min(heights[left], heights[right]) - heights[bottom];

                // Add trapped water for this valley
                if (boundedHeight > 0) {
                    water += boundedHeight * width;
                }
            }

            // Push current index as a potential boundary
            stack.push(i);
        }

        return water;
    }

    public static void main(String[] args) {
        System.out.println(trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1})); // 6
        System.out.println(trap(new int[]{4,2,0,3,2,5}));            // 9
        System.out.println(trap(new int[]{}));                       // 0
    }
}