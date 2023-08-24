package First_Interview.Eight_Interview;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    
    TreeNode(int val) {
        this.val = val;
    }
}

public class Solution2 {
    public TreeNode sufficientSubset(TreeNode root, int limit) {
        if (root == null) {
            return null;
        }
        
        if (root.left == null && root.right == null) {
            return root.val < limit ? null : root;
        }
        
        root.left = sufficientSubset(root.left, limit - root.val);
        root.right = sufficientSubset(root.right, limit - root.val);
        
        return root.left == null && root.right == null ? null : root;
    }
    
    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        
        // Construct the example tree
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(3);
        root1.left.left = new TreeNode(4);
        root1.left.right = new TreeNode(-99);
        root1.right.left = new TreeNode(-99);
        root1.right.right = new TreeNode(7);
        root1.left.left.left = new TreeNode(8);
        root1.left.left.right = new TreeNode(9);
        root1.left.right.left = new TreeNode(-99);
        root1.left.right.right = new TreeNode(-99);
        root1.right.right.left = new TreeNode(12);
        root1.right.right.right = new TreeNode(13);
        root1.left.left.left.left = new TreeNode(-99);
        root1.left.left.left.right = new TreeNode(14);
        
        TreeNode result1 = solution.sufficientSubset(root1, 1);
        printTree(result1);
    }
    
    private static void printTree(TreeNode root) {
        if (root == null) {
            return;
        }
        
        System.out.print(root.val + " ");
        printTree(root.left);
        printTree(root.right);
    }
}