package First_Interview.Seventh_interview;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int val) {
        this.val = val;
    }
}

public class Solution2 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        
        if (root == p || root == q) {
            return root;
        }
        
        TreeNode leftLCA = lowestCommonAncestor(root.left, p, q);
        TreeNode rightLCA = lowestCommonAncestor(root.right, p, q);
        
        if (leftLCA != null && rightLCA != null) {
            return root;
        } else if (leftLCA != null) {
            return leftLCA;
        } else {
            return rightLCA;
        }
    }
    
    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);
        
        TreeNode p = root.left;
        TreeNode q = root.right;
        System.out.println(solution.lowestCommonAncestor(root, p, q).val);  // Output: 3
        
        p = root.left;
        q = root.left.right.right;
        System.out.println(solution.lowestCommonAncestor(root, p, q).val);  // Output: 5
        
        p = root.left.left;
        q = root.left.right;
        System.out.println(solution.lowestCommonAncestor(root, p, q).val);  // Output: 5
    }
}
