package First_Interview.Second_interview;

import java.util.HashMap;
import java.util.Map;

public class Solution3 {
    public int maxPoints(int[][] points) {
        int n = points.length;
        if (n <= 2) {
            return n; // If there are less than or equal to 2 points, they all lie on the same line
        }
        
        int maxPoints = 0;
        
        for (int i = 0; i < n; i++) {
            Map<String, Integer> slopeCount = new HashMap<>(); // Map to store the count of points with the same slope
            
            int duplicatePoints = 0; // Count of duplicate points with the same (x, y) coordinates
            int currentMax = 0; // Maximum number of points on the same line passing through the current point
            
            for (int j = i + 1; j < n; j++) {
                int x1 = points[i][0];
                int y1 = points[i][1];
                int x2 = points[j][0];
                int y2 = points[j][1];
                
                if (x1 == x2 && y1 == y2) {
                    duplicatePoints++;
                    continue;
                }
                
                int dx = x2 - x1;
                int dy = y2 - y1;
                int gcd = gcd(dx, dy); // Calculate the greatest common divisor of dx and dy
                
                // Calculate the reduced form of slope using gcd
                String slope = (dy / gcd) + "_" + (dx / gcd);
                
                slopeCount.put(slope, slopeCount.getOrDefault(slope, 0) + 1);
                currentMax = Math.max(currentMax, slopeCount.get(slope));
            }
            
            maxPoints = Math.max(maxPoints, currentMax + duplicatePoints + 1); // Add 1 for the current point itself
        }
        
        return maxPoints;
    }
    
    // Helper method to calculate the greatest common divisor (gcd) of two numbers using Euclidean algorithm
    private int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
    
    public static void main(String[] args) {
        Solution3 solution = new Solution3();
        
        int[][] points1 = {{1, 1}, {2, 2}, {3, 3}};
        int maxPoints1 = solution.maxPoints(points1);
        System.out.println("Max points on the same line: " + maxPoints1);
        
        int[][] points2 = {{1, 1}, {3, 2}, {5, 3}, {4, 1}, {2, 3}, {1, 4}};
        int maxPoints2 = solution.maxPoints(points2);
        System.out.println("Max points on the same line: " + maxPoints2);
    }
}