import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class Solution {
    public static List<List<Integer>> getSkyline(int[][] buildings) {
        List<List<Integer>> result = new ArrayList<>();

        // Create a list to store the critical points
        List<int[]> criticalPoints = new ArrayList<>();

        // Convert building information to critical points
        for (int[] building : buildings) {
            // Use negative height to represent the start of a building
            criticalPoints.add(new int[]{building[0], -building[2]});
            // Use positive height to represent the end of a building
            criticalPoints.add(new int[]{building[1], building[2]});
        }

        // Sort critical points based on x-coordinates and heights
        Collections.sort(criticalPoints, (a, b) -> {
            if (a[0] != b[0]) {
                return Integer.compare(a[0], b[0]);
            } else {
                // If two points have the same x-coordinate, use heights to sort
                return Integer.compare(a[1], b[1]);
            }
        });

        // Use a max heap to store the heights of active buildings
        Queue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        // Add the ground level to the heap
        maxHeap.offer(0);

        // Previous max height
        int prevMaxHeight = 0;

        for (int[] point : criticalPoints) {
            int x = point[0];
            int h = point[1];

            if (h < 0) {
                // Start of a building
                maxHeap.offer(-h);
            } else {
                // End of a building
                maxHeap.remove(h);
            }

            // Get the current max height from the heap
            int currentMaxHeight = maxHeap.peek();

            // If the max height changes, add a key point to the result
            if (currentMaxHeight != prevMaxHeight) {
                result.add(List.of(x, currentMaxHeight));
                prevMaxHeight = currentMaxHeight;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[][] buildings1 = {{2, 9, 10}, {3, 7, 15}, {5, 12, 12}, {15, 20, 10}, {19, 24, 8}};
        System.out.println(getSkyline(buildings1));

        int[][] buildings2 = {{0, 2, 3}, {2, 5, 3}};
        System.out.println(getSkyline(buildings2));
    }
}
