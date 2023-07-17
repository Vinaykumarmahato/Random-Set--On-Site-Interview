package First_Interview.Second_interview;

public class Solution2 {
    public int uniquePaths(int m, int n) {
        // Create a 2D grid to store the number of unique paths
        int[][] dp = new int[m][n];

        // Initialize the number of unique paths for the first row and column
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int j = 0; j < n; j++) {
            dp[0][j] = 1;
        }

        // Calculate the number of unique paths for each cell in the grid
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }

        // Return the number of unique paths for the bottom-right corner
        return dp[m - 1][n - 1];
    }

    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        int m = 3;
        int n = 7;
        int paths = solution.uniquePaths(m, n);
        System.out.println("Number of unique paths: " + paths);
    }
}
