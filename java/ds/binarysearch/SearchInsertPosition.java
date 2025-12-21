package ds.binarysearch;

public class SearchInsertPosition {

    private static int searchInsert(int[] array, int target) {
        if(array == null || array.length == 0) return 0;

        int lo = 0;
        int hi = array.length - 1;

        while(lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if(array[mid] >= target) hi = mid - 1;
            else lo = mid + 1;
        }
        return lo;

    }

    public static void main(String[] args) {
        System.out.println(searchInsert(new int[]{1,3,5,6}, 5)); // 2
        System.out.println(searchInsert(new int[]{1,3,5,6}, 2)); // 1
        System.out.println(searchInsert(new int[]{1,3,5,6}, 7)); // 4
        System.out.println(searchInsert(new int[]{1,3,5,6}, 0)); // 0
    }
}
