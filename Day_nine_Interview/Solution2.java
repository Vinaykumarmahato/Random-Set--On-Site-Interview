package First_Interview.Day_nine_Interview;

public class Solution2 {

    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        
        for (int row = n - 2; row >= 0; row--) {
            for (int col = 0; col < n; col++) {
                int minSum = matrix[row + 1][col];
                if (col > 0) {
                    minSum = Math.min(minSum, matrix[row + 1][col - 1]);
                }
                if (col < n - 1) {
                    minSum = Math.min(minSum, matrix[row + 1][col + 1]);
                }
                matrix[row][col] += minSum;
            }
        }
        
        int minPathSum = Integer.MAX_VALUE;
        for (int col = 0; col < n; col++) {
            minPathSum = Math.min(minPathSum, matrix[0][col]);
        }
        
        return minPathSum;
    }

    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        
        int[][] matrix1 = {{2,1,3},{6,5,4},{7,8,9}};
        System.out.println("Minimum falling path sum: " + solution.minFallingPathSum(matrix1));
        
        int[][] matrix2 = {{-19,57},{-40,-5}};
        System.out.println("Minimum falling path sum: " + solution.minFallingPathSum(matrix2));
    }
}
