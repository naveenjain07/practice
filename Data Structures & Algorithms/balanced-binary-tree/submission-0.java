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
   
    boolean res = true;
    public boolean isBalanced(TreeNode root) {
        dfs(root);
        return res;
        
    }


    private int dfs(TreeNode node){
        if(node == null){
            return 0;
        }

        int l = dfs(node.left);
        int r = dfs(node.right);

        if(Math.abs(r-l) >1) res= false;
        
        return 1 + Math.max(l,r);
    }
}
