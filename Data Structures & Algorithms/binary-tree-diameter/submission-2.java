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

class Solution {
    int dm = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        depthofSubtree(root);
        return dm;
    }

    private int depthofSubtree(TreeNode node) {
        if (node == null)
            return 0;

        int left = depthofSubtree(node.left);
        int right = depthofSubtree(node.right);
        dm = Math.max(dm, left + right);
        return Math.max(left, right) + 1;
    }
}
