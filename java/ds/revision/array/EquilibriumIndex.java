package ds.revision.array;

public class EquilibriumIndex {
    private static int equilibriumIndex(int[] array) {
        int total = 0;
        for(int i : array) {
            total += i;
        }

        System.out.println(total);

        int leftSum = 0;
        for(int i = 0; i < array.length; i++) {
            // We check before adding so that array[i] belongs to neither side, 
            // and we subtract it from the right because total includes everything
            if(leftSum == total - leftSum - array[i]) {
                return i;
            }

            leftSum += array[i];
        }

        return -1;
    }
    public static void main(String[] args) {
        int[] arr = {1, 7, 3, 6, 5, 6};
        System.out.println(equilibriumIndex(arr));
    }
}
