public class MaxProfit {

    // Brute-force approach:
    // Try every pair of days (buy day and sell day) and keep the best profit.
    // This is simple to understand, but it takes O(n^2) time.
    public static int maxProfitFromStockBruteForce(int[] prices) {
        int maxProfit = 0;
        // i = day when we buy
        for (int i=0; i<prices.length; i++) {
            // j = day when we sell, after the buy day
            for (int j=i+1; j<prices.length; j++) {
                int maxDiff = prices[j]-prices[i];

                // Keep the highest profit found so far.
                maxProfit = Math.max(maxProfit, maxDiff);
            }
        }        
        return maxProfit;
    }

    // Optimized approach:
    // Track the lowest price seen so far.
    // At each day, the best profit is current price - minimum price seen before.
    // This gives O(n) time and O(1) extra space.
    public static int maxProfitFromStock(int[] prices) {
        int maxProfit = 0;
        // Assume the first price is the best buy price seen so far.
        int sellPrice = prices[0];
        for (int i=1; i<prices.length; i++) {
            // If today is cheaper than the previous minimum, update the minimum buy price.
            if (prices[i] < sellPrice) {
                sellPrice = prices[i];
            }
            // Profit if we buy at the lowest price seen so far and sell today.
            int profit = prices[i]-sellPrice;
            maxProfit = Math.max(profit, maxProfit);
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        System.out.println("Max Profit from selling the stock using the brute force approach: "+ maxProfitFromStockBruteForce(prices));
        System.out.println("Max Profit from selling the stock using the optimised approach:"+maxProfitFromStock(prices));
    }
}