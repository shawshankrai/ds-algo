package ds.revision.array;

import java.util.Map;
import java.util.Arrays;
import java.util.HashMap;

public class TwoSumHashMap {

    private static int[] twoSum(int[] numbers, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int i = 0; i < numbers.length; i++) {
            int need = target - numbers[i];
            if(map.containsKey(need)) {
                return new int[] {map.get(need), i};
            }

            map.put(numbers[i], i);
        }

        return new int[] {-1, -1};
    }
    
    public static void main(String[] args) {
        int[] nums = new int[]{2, 7, 11, 15};
        int target = 9;
        System.out.println(Arrays.toString(twoSum(nums, target)));

        nums = new int[]{3, 2, 4};
        target = 6;
        System.out.println(Arrays.toString(twoSum(nums, target)));

    }
}
