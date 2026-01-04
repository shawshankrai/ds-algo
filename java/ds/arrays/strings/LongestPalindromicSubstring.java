package ds.arrays.strings;

// Expand Around Center (String Two-Pointer Variant)
public class LongestPalindromicSubstring {
    private static String longestPalindromicSubstring(String s) {
        if(s == null || s.isEmpty()) return "";
        int start = 0;
        int end = 0;
        int maxLen = 0;

        for(int i = 0; i < s.length(); i++) {
            int lenOdd = expand(i ,i, s);
            int lenEven = expand(i, i + 1, s);
            maxLen = Math.max(lenOdd, lenEven);

            if(maxLen > end - start + 1) {
                start = i - (maxLen - 1) / 2;
                end = i + maxLen / 2;
            }
        }

        return s.substring(start, end + 1);
    }

    private static int expand(int left, int right, String s) {
        while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left --;
            right ++;
        }

        // in the last iteration there is one extra move of unchecked left and right
        // (right - 1) - (left + 1) + 1
        return right - left - 1;
    }
    public static void main(String[] args) {
        System.out.println(longestPalindromicSubstring("abba"));
    }
}
