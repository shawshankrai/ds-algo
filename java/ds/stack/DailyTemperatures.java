package ds.stack;

import java.util.Arrays;
import java.util.Stack;

public class DailyTemperatures {

    private static int[] dailyTemperatures(int[] temps) {
        if(temps == null || temps.length == 0) return new int[0];

        int[] res = new int[temps.length];
        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < temps.length; i++) {
            while(!stack.isEmpty() && temps[i] > temps[stack.peek()]) {
                int idx = stack.pop();
                res[idx] = i - idx;
            }

            stack.push(i);
        }

        return res;
    }
    public static void main(String[] args) {
        System.out.println(Arrays.toString(
            dailyTemperatures(new int[]{73,74,75,71,69,72,76,73})
        ));
    }
}
