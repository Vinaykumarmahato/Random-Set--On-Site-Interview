public class Solution1 {
    public static int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1) {
            return 0; // No profit can be made with less than 2 prices
        }

        int maxProfit = 0;
        int minPrice = prices[0];

        for (int i = 1; i < prices.length; i++) {
            // Update the minimum price if a lower price is encountered
            minPrice = Math.min(minPrice, prices[i]);

            // Calculate the potential profit if selling at the current price
            int potentialProfit = prices[i] - minPrice;

            // Update the maximum profit if the potential profit is greater
            maxProfit = Math.max(maxProfit, potentialProfit);
        }

        return maxProfit;
    }

    public static void main(String[] args) {
        // Example 1
        int[] prices1 = {7, 1, 5, 3, 6, 4};
        System.out.println("Example 1: " + maxProfit(prices1)); // Output: 5

        // Example 2
        int[] prices2 = {7, 6, 4, 3, 1};
        System.out.println("Example 2: " + maxProfit(prices2)); // Output: 0
    }
}