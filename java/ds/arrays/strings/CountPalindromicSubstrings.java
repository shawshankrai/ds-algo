package ds.arrays.strings;

public class CountPalindromicSubstrings {
    private static int countPalindromicSubstring(String s) {
        int count = 0;

        for(int i = 0; i < s.length(); i++) {
            int evenCount = expand(i , i + 1, s);
            int oddCount = expand(i, i, s);

            count += evenCount + oddCount;
        }

        return count;
    }

    private static int expand(int left, int right, String s) {
        int count = 0;
        while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            count ++;
            right ++;
            left --;
        }

        return count;
    }
    public static void main(String[] args) {
        System.out.println(countPalindromicSubstring("abba"));
    }
}
