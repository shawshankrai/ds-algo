package java.ds.arrays.twopointer;

public class MoveZeros {
    
    public static int[] moveZeros(int[] array) {
        int write = 0; 
        
        if(array == null) return null;
        
        for(int read = 0; read < array.length; read++) {
            if(array[read] != 0) {
                array[write] = array[read];
                write ++;
            }
        }

        while (write < array.length) {
            array[write] = 0;
            write ++;
        }
        
        return array;
    }

    public static void main(String[] args) {
        int[] input = {0, 1, 0, 3, 12};
        for(int x : moveZeros(input)) {
            System.out.println(x);
        }
    }
}
