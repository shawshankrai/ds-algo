package ds.arrays.prefixsum;

import java.util.Map;
import java.util.HashMap;

public class SubarraySumEqualsK {
    
    private static int subarraySum(int[] array, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        int answer = 0;
        int sum = 0;

        for(int x = 0; x < array.length; x++) {
            sum += array[x];

            answer += map.getOrDefault(sum - k, 0);

            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        return answer;
    }
    public static void main(String[] args) {
        System.out.println(subarraySum(new int[]{1, 2, 3}, 3));   // 2
        System.out.println(subarraySum(new int[]{1, 1, 1}, 2));   // 2
        System.out.println(subarraySum(new int[]{0, 0, 0}, 0));   // 6
    }
}
