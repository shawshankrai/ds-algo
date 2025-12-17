package arrays.prefixsum;

import java.util.Map;
import java.util.HashMap;

public class LongestSubarraySumEqualsK {
    private static int longestSubarray(int[] array, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);

        int sum = 0;
        int maxLength = 0;
        for(int i = 0; i < array.length; i++) {
            sum += array[i];

            if(map.containsKey(sum - k)) {
                maxLength = Math.max(maxLength, i - map.get(sum - k));
            }

            // In the counting version we store prefix-sum frequencies, 
            // but in the longest-length version we store the earliest index so we can maximize the distance.
            map.putIfAbsent(sum, i);
        }

        return maxLength;
    }

    public static void main(String[] args) {
        System.out.println(longestSubarray(new int[]{1, 2, 3}, 3));        // 2
        System.out.println(longestSubarray(new int[]{1, -1, 5, -2, 3}, 3)); // 4
        System.out.println(longestSubarray(new int[]{-2, -1, 2, 1}, 1));    // 2
    }
}
