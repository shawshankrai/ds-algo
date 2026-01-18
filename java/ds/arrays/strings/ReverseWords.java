package ds.arrays.strings;

public class ReverseWords {

    private static String reverseWords(String s) {
        if(s == null || s.isEmpty()) return "";
        StringBuilder sb = new StringBuilder();

        int right = s.length() - 1;

        while (right >= 0) {
            // compact spaces
            while(right >= 0 && s.charAt(right) == ' ') right --;
            
            // skip if reach end
            if(right < 0) break;

            // form word
            int end = right;
            while(right >=0 && s.charAt(right) != ' ') right --;
            int start = right + 1; // because right ends at space

            if(sb.length() > 0) sb.append(' ');
            sb.append(s, start, end + 1);

        }
        
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(reverseWords("the sky is blue"));      // "blue is sky the"
        System.out.println(reverseWords("  hello   world  "));   // "world hello"
        System.out.println(reverseWords("a good   example"));    // "example good a"
    }
}