package ds.arrays.binarysearch;

public class LastOccurrence {

    private static int lastOccurrence(int[] array, int target) {
        if(array == null || array.length == 0) return -1;
        int ans = -1;

        int lo = 0;
        int hi = array.length - 1;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if(array[mid] == target) {
                ans = mid;
                lo = mid + 1;
            } else if(array[mid] < target) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(lastOccurrence(new int[]{1,2,2,2,3,4}, 2)); // 3
        System.out.println(lastOccurrence(new int[]{1,1,1}, 1));       // 2
        System.out.println(lastOccurrence(new int[]{1,2,3}, 5));       // -1
    }
}
