package ds.revision.array;

public class SubArrayProductLessThanK {

    private static int subArrayProductLessThanK(int[] array, int k) {
        if(array == null || array.length == 0) return 0;
        if(k < 1) return 0;

        int left = 0;
        long product = 1;
        int count = 0;

        for(int right = 0; right < array.length; right++) {
            product *= array[right];
            while(product >= k) {
                product /= array[left++];
            }
            count += right - left + 1;
        }

        return count;
    }
    public static void main(String[] args) {
        System.out.println(subArrayProductLessThanK(new int[]{10, 5, 2, 6}, 100)); // 8
        System.out.println(subArrayProductLessThanK(new int[]{1, 2, 3}, 0));      // 0
        System.out.println(subArrayProductLessThanK(new int[]{1, 1, 1}, 2));     // 6
    }
}
