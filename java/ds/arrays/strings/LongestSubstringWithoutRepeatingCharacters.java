package ds.arrays.strings;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharacters {

    private static int longestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();

        int answer = 0;
        int start = 0;
        for(int end = 0; end < s.length(); end++) {
            char ch = s.charAt(end);
            
            if(map.containsKey(ch)) {
                start = Math.max(start, map.get(ch) + 1); // chose next to start to cut it off from current window
            }

            answer = Math.max(answer, end - start + 1);
            map.put(ch, end);
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(longestSubstring("abcabcbb"));
        System.out.println(longestSubstring("bbbbbb"));
    }
}
