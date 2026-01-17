package ds.arrays.strings;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class GroupAnagrams {

    private static List<List<String>> groupedAnagrams(String[] strings) {
        Map<String, List<String>> map = new HashMap<>();

        for(String s: strings) {
            int[] count = new int[26];
            for(int i = 0; i < s.length(); i++) {
                char ch = Character.toLowerCase(s.charAt(i));
                count[ch - 'a']++;
            }

            StringBuilder key = new StringBuilder();
            for(int i = 0; i < count.length; i++) {
                key.append(count[i]).append("#");
            }

            map.computeIfAbsent(key.toString(), n -> new ArrayList<>()).add(s);
        }

        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        String[] input = {"eat","tea","tan","ate","nat","bat"};
        System.out.println(groupedAnagrams(input));
    }
}
