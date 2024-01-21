package Date_21_01_2024;

class Solution3 {
    public int minDistance(int[] houses, int k) {
        Arrays.sort(houses);
        int n = houses.length;
        int[][] dp = new int[n + 1][k + 1];

        for (int i = 0; i <= n; i++) {
            Arrays.fill(dp[i], -1);
        }

        return calculateMinDistance(houses, n, k, 0, dp);
    }

    private int calculateMinDistance(int[] houses, int n, int k, int start, int[][] dp) {
        if (k == 0 && start == n) {
            return 0;
        }
        if (k == 0 || start == n) {
            return Integer.MAX_VALUE;
        }

        if (dp[start][k] != -1) {
            return dp[start][k];
        }

        int result = Integer.MAX_VALUE;
        for (int end = start; end < n; end++) {
            int median = getMedian(houses, start, end);
            int cost = calculateCost(houses, start, end, median);
            int nextResult = calculateMinDistance(houses, n, k - 1, end + 1, dp);

            if (nextResult != Integer.MAX_VALUE) {
                result = Math.min(result, cost + nextResult);
            }
        }

        dp[start][k] = result;
        return result;
    }

    private int getMedian(int[] houses, int start, int end) {
        return houses[(start + end) / 2];
    }

    private int calculateCost(int[] houses, int start, int end, int median) {
        int cost = 0;
        for (int i = start; i <= end; i++) {
            cost += Math.abs(houses[i] - median);
        }
        return cost;
    }
}
