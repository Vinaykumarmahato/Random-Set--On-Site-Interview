package First_Interview.Third_Interview;

import java.util.*;

class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] colors = new int[n]; // Array to store the color of each node
        Arrays.fill(colors, -1); // Initialize all colors as unassigned
        
        for (int i = 0; i < n; i++) {
            if (colors[i] == -1) { // Node not yet colored
                if (!isBipartiteDFS(graph, i, colors)) {
                    return false; // Found a conflict, graph is not bipartite
                }
            }
        }
        
        return true; // All nodes have been successfully colored
    }
    
    private boolean isBipartiteDFS(int[][] graph, int node, int[] colors) {
        if (colors[node] == -1) {
            colors[node] = 0; // Color the current node as 0
        }
        
        for (int neighbor : graph[node]) {
            if (colors[neighbor] == -1) { // Neighbor not yet colored
                colors[neighbor] = 1 - colors[node]; // Assign the opposite color
                if (!isBipartiteDFS(graph, neighbor, colors)) {
                    return false; // Found a conflict, graph is not bipartite
                }
            } else if (colors[neighbor] == colors[node]) {
                return false; // Found a conflict, graph is not bipartite
            }
        }
        
        return true; // All nodes reachable from the current node have been successfully colored
    }
}

public class Solution3 {
    public static void main(String[] args) {
        Solution solution = new Solution();

        int[][] graph1 = {{1, 2, 3}, {0, 2}, {0, 1, 3}, {0, 2}};
        boolean isBipartite1 = solution.isBipartite(graph1);
        System.out.println("Graph 1 is bipartite: " + isBipartite1);

        int[][] graph2 = {{1, 3}, {0, 2}, {1, 3}, {0, 2}};
        boolean isBipartite2 = solution.isBipartite(graph2);
        System.out.println("Graph 2 is bipartite: " + isBipartite2);
    }
}