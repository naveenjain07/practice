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

    int maxHeight = 0;
    public int maxDepth(TreeNode root) {
        if(root == null) {
            return 0;
        }
        maxHeight = Math.max(maxDepth(root.left), maxDepth(root.right))+1; 
   
        return maxHeight;
    }
}
