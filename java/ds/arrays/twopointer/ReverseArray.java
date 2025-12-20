package java.ds.arrays.twopointer;

public class ReverseArray {

    public static int[] reverseArray(int[] array) {
        int left = 0;
        int right = array.length - 1;

        while (left < right) {
            int temp = array[left];
            array[left] = array[right];
            array[right] = temp;
            
            left ++;
            right --;
        }

        return  array;
    }
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5}; 
        int[] result = reverseArray(array);

        for(int x : result) {
            System.out.println(x);
        }
    }
}
