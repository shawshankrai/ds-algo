package ds.revision.array;

import java.util.Map;
import java.util.HashMap;

public class SubArraySumsDivisibleByK {

    private static int subArraySumsDivisibleByK(int[] numbers, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        int ans = 0;
        int prefixSum = 0;
        
        for(int num : numbers) {
            prefixSum += num;
            int rem = prefixSum % k;
            rem = (rem + k) % k; // overflow fix

            ans += map.getOrDefault(rem, 0);
            map.put(rem, map.getOrDefault(rem, 0) + 1);
        }

        return ans;
    }
    public static void main(String[] args) {
        int [] numbers = new int[] {4, 5, 0, -2, -3, 1};
        int k = 5;

        System.out.println(subArraySumsDivisibleByK(numbers, k));
    }
}
