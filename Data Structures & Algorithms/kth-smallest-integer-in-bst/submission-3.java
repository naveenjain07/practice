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
    List<Integer> res = new ArrayList<>();
    int k = 0;
    public int kthSmallest(TreeNode root, int k) {
        this.k = k;
        dfs(root); 
       return res.get(k-1);
    }


    private void dfs(TreeNode node){

        if(node == null || res.size() == k){
            return;
        }

        dfs(node.left);
        res.add(node.val);
        dfs(node.right);
    }
}
