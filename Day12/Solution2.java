public class Solution2 {
    public static int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1) {
            return 0; // No profit can be made with less than 2 prices
        }

        int n = prices.length;

        // dp[i][j] represents the maximum profit up to day i with j transactions
        int[][] dp = new int[n][3];

        // Initialize the dp array
        for (int i = 1; i <= 2; i++) {
            int maxDiff = -prices[0];
            for (int day = 1; day < n; day++) {
                dp[day][i] = Math.max(dp[day - 1][i], prices[day] + maxDiff);
                maxDiff = Math.max(maxDiff, dp[day][i - 1] - prices[day]);
            }
        }

        return dp[n - 1][2];
    }

    public static void main(String[] args) {
        // Example 1
        int[] prices1 = {3, 3, 5, 0, 0, 3, 1, 4};
        System.out.println("Example 1: " + maxProfit(prices1)); // Output: 6

        // Example 2
        int[] prices2 = {1, 2, 3, 4, 5};
        System.out.println("Example 2: " + maxProfit(prices2)); // Output: 4

        // Example 3
        int[] prices3 = {7, 6, 4, 3, 1};
        System.out.println("Example 3: " + maxProfit(prices3)); // Output: 0
    }
}