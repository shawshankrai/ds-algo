package ds.arrays.binarysearch;

public class ShipWithinDays {
    private static int shipWithinDays(int[] weights, int days) {
        if(weights == null || weights.length == 0) return 0;

        int lo = 0;
        int hi = 0;

        for(int w : weights) {
            lo = Math.max(lo, w);
            hi += w;
        }

        while(lo <= hi) {
            int mid = lo + (hi - lo) / 2;

            if (canShip(weights, days, mid)) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        
        return lo;
    }

    private static boolean canShip(int[] weights, int days, int capacity) {
        // starts with day 1
        int usedDays = 1;
        int load = 0;

        for(int w : weights) {
            if(load + w > capacity) {
                usedDays ++;
                load = 0;
            }

            load += w;

            if(usedDays > days) return false;
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(shipWithinDays(new int[]{1,2,3,4,5,6,7,8,9,10}, 5)); // 15
        System.out.println(shipWithinDays(new int[]{3,2,2,4,1,4}, 3));          // 6
    }
}
