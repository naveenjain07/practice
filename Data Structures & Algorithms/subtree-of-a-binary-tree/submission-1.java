class Solution {
    
    // 1. THE SCOUT (Pre-order DFS)
    // Job: Traverse the main tree looking for a node that matches the top of subRoot.
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        // Base case: If we reach the bottom of a branch without finding it
        if (root == null) return false;
        
        // If we find a node with the same value, send in the Verifier!
        if (isSameTree(root, subRoot)) {
            // If the Verifier says it's a perfect match, we are completely done.
            return true;
        }
        
        // THE DUPLICATE SAVIOR: 
        // If the Verifier returned false (it was a fake-out), this line executes.
        // It simply tells the Scout to keep checking the left and right branches!
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    // 2. THE VERIFIER (DFS)
    // Job: Given two specific nodes, check if their branches are 100% identical.
    private boolean isSameTree(TreeNode p, TreeNode q) {
        // Both hit null at the same time? Perfect match!
        if (p == null && q == null) return true;
        
        // One hit null early, OR the numbers don't match? Failure!
        if (p == null || q == null || p.val != q.val) return false;
        
        // Check both the left branches AND the right branches
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}