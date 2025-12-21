package ds.binarysearch;

public class CountOccurrences {
    private static int countOccurrences(int[] array, int target) {
        if(array == null || array.length == 0) return 0;

        int first = -1;
        int lo = 0;
        int hi = array.length -1;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if(array[mid] >= target) hi = mid - 1;
            else lo = mid + 1;
            if(array[mid] == target) first = mid;
        }

        if(first == -1) return 0;

        lo = 0;
        hi = array.length -1;
        int last = -1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if(array[mid] <= target) lo = mid + 1;
            else hi = mid - 1;
            if(array[mid] == target) last = mid;
        }

        return last - first + 1;
    }
    public static void main(String[] args) {
        System.out.println(countOccurrences(new int[]{1,2,2,2,3,4}, 2)); // 3
        System.out.println(countOccurrences(new int[]{1,1,1}, 1));       // 3
        System.out.println(countOccurrences(new int[]{1,2,3}, 5));       // 0
    }
}
