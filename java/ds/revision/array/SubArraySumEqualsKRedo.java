package ds.revision.array;

import java.util.Map;
import java.util.HashMap;

public class SubArraySumEqualsKRedo {
    
    private static int countContiguousSubArray(int[] numbers, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        
        int total = 0;
        int ans = 0;

        for(int num : numbers) {
            total += num;
            int z = total - k;
            ans += map.getOrDefault(z, 0);
            map.put(total, map.getOrDefault(total, 0) + 1);
        }

        return ans;
    }
    public static void main(String[] args) {
        int[] numbers = {1, 1, 1};
        int k = 2;

        System.out.println(countContiguousSubArray(numbers, k));
    }
}
