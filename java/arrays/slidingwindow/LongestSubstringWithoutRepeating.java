package arrays.slidingwindow;

import java.util.Set;
import java.util.Arrays;
import java.util.HashSet;

public class LongestSubstringWithoutRepeating {

    private static int longestSubstringWithoutRepeating(String s) {
        if(s == null || s.isEmpty()) return 0;
        
        Set<Character> set = new HashSet<>();
        int start = 0;
        int maxSize = 0;
        for(int end = 0; end < s.length(); end++) {
            Character c = s.charAt(end);

            while(set.contains(c)) {
                set.remove(s.charAt(start));
                start ++;
            }

            set.add(c);

            maxSize = Math.max(maxSize, end - start + 1);
        }

        return maxSize;
    }

    private static int longestSubstringWithoutRepeatingWithLastSeen(String s) {
        if(s == null || s.isEmpty()) return 0;

        int[] lastSeen = new int[256];
        Arrays.fill(lastSeen, -1);

        int maxLength = 0;
        int start = 0;

        for(int end = 0; end < s.length(); end++) {
            char c = s.charAt(end);

            // checks for duplicate
            if(lastSeen[c] >= start) {
                start = lastSeen[c] + 1;
            }

            lastSeen[c] = end;

            maxLength = Math.max(maxLength, end - start + 1);
        }

        return maxLength;
    }

    public static void main(String[] args) {
        String input = "wpwkewy";
        System.out.println(longestSubstringWithoutRepeating(input));
        System.out.println(longestSubstringWithoutRepeatingWithLastSeen(input));
    }
}
