package ds.arrays.binarysearch;

public class FirstOccurrence {
    private static int firstOccurrence(int[] array, int target) {
        if(array == null || array.length == 0) return -1;
        
        int ans = -1;
        int lo = 0;
        int hi = array.length - 1;

        while(lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if(array[mid] == target) {
                ans = mid;
                hi = mid - 1;
            } else if (array[mid] < target) {
                lo = mid + 1;
            } else {
                 hi = mid -1;
            }
        }

        return ans;

    }
    public static void main(String[] args) {
        System.out.println(firstOccurrence(new int[]{1,2,2,2,3,4}, 2)); // 1
        System.out.println(firstOccurrence(new int[]{1,1,1}, 1));       // 0
        System.out.println(firstOccurrence(new int[]{1,2,3}, 5));       // -1
    }
}
