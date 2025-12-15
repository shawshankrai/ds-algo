package arrays.slidingwindow;

import java.util.Map;
import java.util.HashMap;

public class LongestSubstringAtMostKDistinctCharacters {

    private static int longestSubstringAtMostKDistinctCharacters(String s, int k) {
        if(s == null || s.isEmpty() || k == 0) return 0;
        
        Map<Character, Integer> map = new HashMap<>();

        int maxLength = 0;
        int start = 0;
        for(int end = 0; end < s.length(); end++) {
            char character = s.charAt(end);
            map.put(character, map.getOrDefault(character, 0) + 1);

            // The while loop is only responsible for restoring validity.
            // Once the invariant is restored, I update the answer exactly once.
            while(map.size() > k) {
                char left = s.charAt(start);
                map.put(left, map.get(left) - 1);
                if(map.get(left) == 0) {
                    map.remove(left);
                }
                start ++;
            }

            maxLength = Math.max(maxLength, end - start + 1);
        }

        return maxLength;
    }

    public static void main(String[] args) {
        String input = "eceba";
        System.out.println(longestSubstringAtMostKDistinctCharacters(input, 2));
    }
    
}
