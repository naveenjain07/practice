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
 */class Solution {
    // 1. Start by assuming the tree is perfectly balanced
    boolean isBal = true; 
    
    public boolean isBalanced(TreeNode root) {
        // 2. Trigger the recursion. Do NOT assign the result to isBal!
        dfs(root);
        
        // 3. Return the global tracker
        return isBal;
    }

    private int dfs(TreeNode node){
        if (node == null) {
            return 0;
        }

        int l = dfs(node.left);
        int r = dfs(node.right);

        // 4. If we find an imbalance anywhere, flip the global tracker to false
        if (Math.abs(r - l) > 1) {
            isBal = false;
        }
        
        // 5. Always return the height to keep the math working for the parent nodes
        return 1 + Math.max(l, r);
    }
}

// class Solution {
   
//     boolean res = true;
//     public boolean isBalanced(TreeNode root) {
//         dfs(root);
//         return res;
        
//     }


//     private int dfs(TreeNode node){
//         if(node == null){
//             return 0;
//         }

//         int l = dfs(node.left);
//         int r = dfs(node.right);

//         if(Math.abs(r-l) >1) res= false;
        
//         return 1 + Math.max(l,r);
//     }
// }
