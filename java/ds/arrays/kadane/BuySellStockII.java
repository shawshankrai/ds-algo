package ds.arrays.kadane;

public class BuySellStockII {
    private static int maxProfit(int[] prices) {
        if(prices == null || prices.length == 0) return 0;

        // Any long upward slope can be split into smaller profits without loss
        int profit = 0;
        for(int i = 1; i < prices.length; i++) {
            if(prices[i] > prices[i - 1]) {
                profit += prices[i] - prices[i - 1];
            }
        }

        return profit;
    }
    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{7,1,5,3,6,4})); // 5
        System.out.println(maxProfit(new int[]{7,6,4,3,1}));   // 0
    }
}
