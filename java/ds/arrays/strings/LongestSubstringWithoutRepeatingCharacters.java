package ds.arrays.strings;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharacters {

    private static int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() == 0) return 0;
       
        // state: char -> last index seen
        Map<Character, Integer> lastIndex = new HashMap<>();

        int left = 0;   // window start
        int answer = 0;

        for (int right = 0; right < s.length(); right++) {
            char ch = s.charAt(right);

            // if ch seen before and inside current window => move left
            if(lastIndex.containsKey(ch)) {
                left = Math.max(left, lastIndex.get(ch) + 1); // last index + 1, to get new left, can't include same char again
            }

            // update last seen index of ch
            lastIndex.put(ch, right);

            // update best window length
            answer = Math.max(answer, right - left + 1);
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb")); // 3
        System.out.println(lengthOfLongestSubstring("bbbbbb"));   // 1
        System.out.println(lengthOfLongestSubstring("pwwkew"));   // 3
        System.out.println(lengthOfLongestSubstring(""));         // 0
    }
}