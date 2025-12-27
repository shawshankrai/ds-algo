package ds.revision.array;

public class EquilibriumIndexRedo {
    
    private static int equilibriumIndex(int[] array) {
        int total = 0;
        for(int num : array) total += num;

        int leftSum = 0;
        int idx = 0;
        for(int i : array) {
            if(leftSum == total - leftSum - i) {
                return idx;
            }
            leftSum += i;
            idx++;
        }

        return -1;
    }
    public static void main(String[] args) {
        int[] arr = {1, 7, 3, 6, 5, 6};
        System.out.println(equilibriumIndex(arr));
    }
}
