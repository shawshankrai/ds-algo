package ds.arrays.binarysearch;

public class BinarySearchClassic {

    private static int search(int[] num, int target) {
        if(num == null || num.length == 0) return -1;

        int lo = 0;
        int hi = num.length - 1;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
             if(num[mid] == target) return mid;
             else if(num[mid] > target) hi = mid - 1;
             else lo = mid + 1;
        }

        return -1;
    }

    public static void main(String[] args) {
        System.out.println(search(new int[]{1,3,5,7,9}, 7));  // 3
        System.out.println(search(new int[]{1,3,5,7,9}, 2));  // -1
        System.out.println(search(new int[]{1}, 1));          // 0
        System.out.println(search(new int[]{}, 1));           // -1
    }
}
