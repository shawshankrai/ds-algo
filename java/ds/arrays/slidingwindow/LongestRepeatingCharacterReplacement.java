package java.ds.arrays.slidingwindow;

public class LongestRepeatingCharacterReplacement {

    /**
     * Returns the length of the longest substring that can be converted
     * into all the same character using at most k replacements.
     *
     * Sliding Window + Frequency Array
     */
    private static int characterReplacement(String s, int k) {
        // Edge case: empty or null string
        if (s == null || s.isEmpty()) return 0;

        // Frequency of characters in current window (A-Z)
        int[] frequency = new int[26];

        int maxLength = 0;     // Best (maximum) window length found so far
        int maxFrequency = 0;  // Frequency of the most common character in the window
        int start = 0;         // Left boundary of the sliding window

        // Expand the window using 'end'
        for (int end = 0; end < s.length(); end++) {

            // Convert character to index (A -> 0, B -> 1, ..., Z -> 25)
            int idx = s.charAt(end) - 'A';

            // Include current character in the window
            frequency[idx]++;

            // Update maxFrequency (can be slightly stale, and that's OK)
            maxFrequency = Math.max(maxFrequency, frequency[idx]);

            /*
             * Window size            = (end - start + 1)
             * Replacements needed    = window size - maxFrequency
             *
             * If replacements needed > k, window is invalid
             * → shrink from the left
             */
            while ((end - start + 1) - maxFrequency > k) {
                // Remove the leftmost character from the window
                frequency[s.charAt(start) - 'A']--;
                start++;
            }

            // At this point, window is valid → update answer
            maxLength = Math.max(maxLength, end - start + 1);
        }

        return maxLength;
    }

    public static void main(String[] args) {
        System.out.println(characterReplacement("AABABBA", 1)); // 4
        System.out.println(characterReplacement("ABAB", 2));    // 4
        System.out.println(characterReplacement("AAAA", 2));    // 4
        System.out.println(characterReplacement("", 2));        // 0
    }
}