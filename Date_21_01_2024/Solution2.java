package Date_21_01_2024;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution2 {
    public TreeNode balanceBST(TreeNode root) {
        // Step 1: Perform in-order traversal to get sorted values
        List<Integer> values = new ArrayList<>();
        inOrderTraversal(root, values);

        // Step 2: Build a balanced binary search tree using the sorted values
        return buildBalancedBST(values, 0, values.size() - 1);
    }

    private void inOrderTraversal(TreeNode node, List<Integer> values) {
        if (node == null) {
            return;
        }

        inOrderTraversal(node.left, values);
        values.add(node.val);
        inOrderTraversal(node.right, values);
    }

    private TreeNode buildBalancedBST(List<Integer> values, int start, int end) {
        if (start > end) {
            return null;
        }

        int mid = (start + end) / 2;
        TreeNode root = new TreeNode(values.get(mid));

        // Recursively build left and right subtrees
        root.left = buildBalancedBST(values, start, mid - 1);
        root.right = buildBalancedBST(values, mid + 1, end);

        return root;
    }
}