package First_Interview.fifth_interview;

import java.util.Arrays;

class Solution {
    private int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    private int[][] memo;

    public int longestIncreasingPath(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        memo = new int[m][n];
        int maxLength = 0;

        for (int i = 0; i < m; i++) {
            Arrays.fill(memo[i], -1);
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                maxLength = Math.max(maxLength, dfs(matrix, i, j));
            }
        }

        return maxLength;
    }

    private int dfs(int[][] matrix, int row, int col) {
        if (memo[row][col] != -1) {
            return memo[row][col];
        }

        int maxLength = 1;

        for (int[] direction : directions) {
            int newRow = row + direction[0];
            int newCol = col + direction[1];

            if (newRow >= 0 && newRow < matrix.length &&
                newCol >= 0 && newCol < matrix[0].length &&
                matrix[newRow][newCol] > matrix[row][col]) {
                maxLength = Math.max(maxLength, 1 + dfs(matrix, newRow, newCol));
            }
        }

        memo[row][col] = maxLength;
        return maxLength;
    }
}

public class Solution4 {
    public static void main(String[] args) {
        Solution solution = new Solution();

        int[][] matrix1 = {{9, 9, 4}, {6, 6, 8}, {2, 1, 1}};
        System.out.println(solution.longestIncreasingPath(matrix1)); // Output: 4

        int[][] matrix2 = {{3, 4, 5}, {3, 2, 6}, {2, 2, 1}};
        System.out.println(solution.longestIncreasingPath(matrix2)); // Output: 4

        int[][] matrix3 = {{1}};
        System.out.println(solution.longestIncreasingPath(matrix3)); // Output: 1
    }
}

