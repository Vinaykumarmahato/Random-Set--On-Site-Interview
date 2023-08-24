package First_Interview.Eight_Interview;

public class Solution1 {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if (image[sr][sc] == newColor) {
            return image; // No need to perform flood fill if the starting pixel already has the new color
        }
        
        fill(image, sr, sc, image[sr][sc], newColor);
        return image;
    }
    
    private void fill(int[][] image, int row, int col, int oldColor, int newColor) {
        if (row < 0 || row >= image.length || col < 0 || col >= image[0].length || image[row][col] != oldColor) {
            return;
        }
        
        image[row][col] = newColor;
        
        fill(image, row + 1, col, oldColor, newColor); // Fill down
        fill(image, row - 1, col, oldColor, newColor); // Fill up
        fill(image, row, col + 1, oldColor, newColor); // Fill right
        fill(image, row, col - 1, oldColor, newColor); // Fill left
    }
    
    public static void main(String[] args) {
        Solution1 solution = new Solution1();
        
        int[][] image1 = {{1,1,1},{1,1,0},{1,0,1}};
        int[][] result1 = solution.floodFill(image1, 1, 1, 2);
        printImage(result1);
        
        int[][] image2 = {{0,0,0},{0,0,0}};
        int[][] result2 = solution.floodFill(image2, 0, 0, 0);
        printImage(result2);
    }
    
    private static void printImage(int[][] image) {
        for (int[] row : image) {
            for (int pixel : row) {
                System.out.print(pixel + " ");
            }
            System.out.println();
        }
    }
}
