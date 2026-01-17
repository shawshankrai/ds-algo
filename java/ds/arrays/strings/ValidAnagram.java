package ds.arrays.strings;

public class ValidAnagram {

    private static boolean isAnagram(String s, String t) {
        if(s == null || t == null) return s == t;
        if(s.length() != t.length()) return false;

        int[] isSeen = new int[26];

        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            isSeen[ch - 'a']++;
        }

        for(int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);
            if(--isSeen[ch - 'a']  < 0) {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        System.out.println(isAnagram("panama", "aanamp"));   // true
        System.out.println(isAnagram("anagram", "nagaram")); // true
        System.out.println(isAnagram("rat", "car"));         // false
    }
}
