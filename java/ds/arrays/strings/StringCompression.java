package ds.arrays.strings;

public class StringCompression {
    private static int compress(char[] array) {
        int read = 0;
        int write = 0;

        int n = array.length;

        while (read < n) {
            char currentChar = array[read];
            int start = read;

            while(read < n && currentChar == array[read])
                read ++;

            array[write++] = currentChar;
            int count = read - start;
            if(count > 1) {
                String stringCount = String.valueOf(count);
                for(int i = 0; i < stringCount.length(); i++) {
                    array[write++] = stringCount.charAt(i);
                }                    
            }
        }

        return write;
    }
    public static void main(String[] args) {
        char[] a = {'a','a','b','b','c','c','c'};
        int lenA = compress(a);
        System.out.println(new String(a, 0, lenA)); // a2b2c3
        // expected content prefix: a 2 b 2 c 3

        char[] b = {'a'};
        int lenB = compress(b);
        System.out.println(new String(b, 0, lenB)); // a
        // expected content prefix: a

        char[] c = {'a','b','b','b','b','b','b','b','b','b','b','b','b'};
        int lenC = compress(c);
        System.out.println(new String(c, 0, lenC)); // ab12
        // expected content prefix: a b 1 2
    }
}
