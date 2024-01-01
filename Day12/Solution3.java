public class Solution3 {
    public static int maxProfit(int k, int[] prices) {
        if (prices == null || prices.length <= 1 || k <= 0) {
            return 0; // No profit can be made with less than 2 prices or non-positive k
        }

        int n = prices.length;

        // If k is large enough, the problem is equivalent to the problem without any transaction limit
        if (k >= n / 2) {
            int maxProfit = 0;
            for (int i = 1; i < n; i++) {
                if (prices[i] > prices[i - 1]) {
                    maxProfit += prices[i] - prices[i - 1];
                }
            }
            return maxProfit;
        }

        // dp[i][j] represents the maximum profit up to day i with j transactions
        int[][] dp = new int[n][k + 1];

        // Initialize the dp array
        for (int trans = 1; trans <= k; trans++) {
            int maxDiff = -prices[0];
            for (int day = 1; day < n; day++) {
                dp[day][trans] = Math.max(dp[day - 1][trans], prices[day] + maxDiff);
                maxDiff = Math.max(maxDiff, dp[day][trans - 1] - prices[day]);
            }
        }

        return dp[n - 1][k];
    }

    public static void main(String[] args) {
        // Example 1
        int k1 = 2;
        int[] prices1 = {2, 4, 1};
        System.out.println("Example 1: " + maxProfit(k1, prices1)); // Output: 2

        // Example 2
        int k2 = 2;
        int[] prices2 = {3, 2, 6, 5, 0, 3};
        System.out.println("Example 2: " + maxProfit(k2, prices2)); // Output: 7
    }
}