package ds.arrays.strings;

import java.util.Arrays;

public class ReverseString {

    private static void reverse(char[] s) {
        if(s == null || s.length == 0) return;

        int left = 0;
        int right = s.length - 1;

        while(left < right) {
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;

            left ++;
            right --;
        }
    }

    public static void main(String[] args) {
        char[] a = {'h','e','l','l','o'};
        reverse(a);
        System.out.println(Arrays.toString(a)); // [o, l, l, e, h]

        char[] b = {'H','a','n','n','a','h'};
        reverse(b);
        System.out.println(Arrays.toString(b)); // [h, a, n, n, a, H]
    }
}