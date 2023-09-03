package First_Interview.Seventh_interview.Tenth_interview;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }
}

public class Solution3 {
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        List<TreeNode> result = new ArrayList<>();
        Set<Integer> toDeleteSet = new HashSet<>();
        for (int val : to_delete) {
            toDeleteSet.add(val);
        }

        if (!toDeleteSet.contains(root.val)) {
            result.add(root);
        }

        deleteNodes(root, toDeleteSet, result);

        return result;
    }

    private TreeNode deleteNodes(TreeNode node, Set<Integer> toDeleteSet, List<TreeNode> result) {
        if (node == null) {
            return null;
        }

        node.left = deleteNodes(node.left, toDeleteSet, result);
        node.right = deleteNodes(node.right, toDeleteSet, result);

        if (toDeleteSet.contains(node.val)) {
            if (node.left != null) {
                result.add(node.left);
            }
            if (node.right != null) {
                result.add(node.right);
            }
            return null; // Node is deleted, return null
        }

        return node;
    }
}