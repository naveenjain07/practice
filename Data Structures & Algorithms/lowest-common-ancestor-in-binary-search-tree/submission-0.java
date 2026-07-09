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
    int p = 0;
    int q = 0;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        this.p = p.val;
        this.q = q.val;
        return dfs(root);
    }

    private TreeNode dfs(TreeNode root) {
        if (root == null)
            return null;
        
        if (p < root.val && q < root.val) {
            return dfs(root.left);
        }
        if (p > root.val && q > root.val) {
            return dfs(root.right);
        }

        return root;
    }
}
