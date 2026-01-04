package ds.arrays.strings;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class GroupAnagrams {

    private static List<List<String>> groupedAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (String s : strs) {
            // build count[26]
            int[] count = new int[26];
            for(int i = 0; i < s.length(); i ++) {
                char ch = s.charAt(i);
                count[ch - 'a'] ++; 
            }
            // convert count -> unique key string
            StringBuilder key = new StringBuilder();
            for(int i = 0; i < count.length; i++) {
                key.append(count[i]).append("#"); 
            }

            // map.computeIfAbsent(key, k -> new ArrayList<>()).add(s);
            map.computeIfAbsent(key.toString(), k -> new ArrayList<>()).add(s);
        }

        return new ArrayList<>(map.values());
    }
    public static void main(String[] args) {
        String[] input = {"eat","tea","tan","ate","nat","bat"};
        System.out.println(groupedAnagrams(input));
    }
}
