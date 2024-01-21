package Date_21_01_2024;

public class Solution1 {
    public static int countNegatives(int[][] grid) {
        int m = grid.length; // Number of rows
        int n = grid[0].length; // Number of columns

        int count = 0; // Counter for negative numbers
        int row = m - 1; // Start from the bottom row
        int col = 0; // Start from the leftmost column

        while (row >= 0 && col < n) {
            if (grid[row][col] < 0) {
              
                count += n - col;
                row--; 
            } else {
                
                col++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int[][] grid1 = {
                {4, 3, 2, -1},
                {3, 2, 1, -1},
                {1, 1, -1, -2},
                {-1, -1, -2, -3}
        };
        System.out.println(countNegatives(grid1)); // Output: 8

        int[][] grid2 = {
                {3, 2},
                {1, 0}
        };
        System.out.println(countNegatives(grid2)); // Output: 0
    }
}