class Solution {
    // 1. Assume they are the same until proven otherwise
    boolean isSame = true; 

    public boolean isSameTree(TreeNode p, TreeNode q) {
        dfs(p, q);
        return isSame;
    }

    private void dfs(TreeNode p, TreeNode q) {
        // 2. If the alarm already tripped somewhere else, stop doing work!
        if (isSame == false) return; 
        
        // 3. Both are null? They match! (Do nothing and return)
        if (p == null && q == null) return;
        
        // 4. Mismatch found! Trip the alarm!
        if (p == null || q == null || p.val != q.val) {
            isSame = false;
            return;
        }
        
        // 5. Compare P's left to Q's left, and P's right to Q's right
        dfs(p.left, q.left);
        dfs(p.right, q.right);
    }
}