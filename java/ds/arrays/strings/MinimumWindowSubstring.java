package ds.arrays.strings;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {

    private static String minWindow(String s, String t) {
        if(s == null || t == null) return "";
        if(s.length() == 0 || t.length() == 0 || s.length() < t.length()) return "";

        // building needs
        Map<Character, Integer> need = new HashMap<>();
        for(char ch : t.toCharArray()) {
            need.put(ch, need.getOrDefault(ch, 0) + 1);
        }

        int left = 0; 
        int missing = t.length();
        int bestStart = 0;
        int bestLen = Integer.MAX_VALUE;
        for(int right = 0; right < s.length(); right++) {
            char ch = s.charAt(right);

            if(need.containsKey(ch)) {
                int before = need.get(ch);
                // check, if the current char is required, then only reduce missing
                if(before > 0) {
                    missing --;
                }
                need.put(ch, before - 1);
            }

            while(missing == 0) {
                int windowLen = right - left + 1;
                if(bestLen > windowLen) {
                    bestLen = right - left + 1;
                    bestStart = left;
                }

                char leftChar = s.charAt(left);
                if(need.containsKey(leftChar)) {
                    int before = need.get(leftChar);
                    need.put(leftChar, before + 1);
                    // only increment if before is less than required
                    if(before + 1 > 0) {
                        missing++;
                    }
                }

                left++;
            }
        }
        return bestLen == Integer.MAX_VALUE ? "" : s.substring(bestStart, bestStart + bestLen);
    }

    public static void main(String[] args) {
        System.out.println(minWindow("ADOBECODEBANC", "ABC")); // "BANC"
        System.out.println(minWindow("a", "a"));               // "a"
        System.out.println(minWindow("a", "aa"));              // ""
    }
}

/*	•	need[ch] > 0 → we still need it
	•	when adding: if need[ch] > 0 then missing--, then need[ch]--
	•	when removing: need[ch]++, if it becomes > 0 then missing++
*/