package arrays.twopointer;

public class RemoveDuplicate {
    
    public static int removeDuplicates(int[] array) {
        if(array == null || array.length == 0) return 0;

        int write = 1;
        for(int read = 1; read < array.length; read ++) {
            // Compare with last unique, write to next free slot
            if(array[read] != array[write - 1]) {
                array[write] = array[read];
                write ++;
            }
        }
        // length of unique array
        return write;
    }
    public static void main(String[] args) {
        int[] input = {0,0,1,1,1,2,2,3,3,4};
        System.out.println(removeDuplicates(input));
    }
}
