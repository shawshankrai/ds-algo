package ds.arrays.strings;

public class ValidAnagram {

    private static boolean isValidAnagram(String s, String t) {
        if(s == null || t == null) return s == t;
        if(s.length() != t.length()) return false;

        int[] count = new int[26];

        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            count[ch - 'a'] ++;
        }

        for(int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);
            if (-- count[ch - 'a'] < 0) return false;
        }

        return true;
    }
    public static void main(String[] args) {
        System.out.println(isValidAnagram("panama", "aanamp"));
    }
}
