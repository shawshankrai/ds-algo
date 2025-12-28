package ds.arrays.kadane;

public class MaximumProductSubArray {
    private static int maximumProductSubArray(int [] array) {
        if(array == null || array.length == 0) return 0;

        int maxProduct = array[0];
        int minProduct = array[0];
        int ans = array[0];

        for(int i = 1; i < array.length; i++ ) {

            if(array[i] < 0) {
                int temp = maxProduct;
                maxProduct = minProduct;
                minProduct = temp;
            }

            maxProduct = Math.max(array[i], array[i] * maxProduct);
            minProduct = Math.min(array[i], array[i] * minProduct);

            ans = Math.max(ans, maxProduct);
        }

        return ans;
    }
    public static void main(String[] args) {
        System.out.println(maximumProductSubArray(new int[] {1, -2, 3, -2}));
        System.out.println(maximumProductSubArray(new int[] {5, -3, 5}));
        System.out.println(maximumProductSubArray(new int[] {-3, -2, -3}));
    }
}
