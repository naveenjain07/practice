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
    
    int count =0;
    public int goodNodes(TreeNode root) {
        
        dfs(root, Integer.MIN_VALUE);
        return count;

    }



    private int dfs(TreeNode node, int maxSoFar){

        if(node == null) {
            return 0;
        }
        if(node.val>= maxSoFar){
            count++;
        }
        maxSoFar = Math.max(maxSoFar, node.val);
        dfs(node.left,maxSoFar);
        dfs(node.right,maxSoFar);
        return count;
    }
}
