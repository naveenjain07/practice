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
//  *         this.left = left;
//  *         this.right = right;
//  *     }
//  * }
//  */
// public class Solution {
//     List<Integer> res = new ArrayList<>();

//     public List<Integer> rightSideView(TreeNode root) {
//         dfs(root, 0);
//         return res;
//     }

//     private void dfs(TreeNode node, int depth) {
//         if (node == null) {
//             return;
//         }

//         if (res.size() == depth) {
//             res.add(node.val);
//         }

//         dfs(node.right, depth + 1);
//         dfs(node.left, depth + 1);
//     }
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        Queue<TreeNode> q = new ArrayDeque<>();

        List<Integer> res = new ArrayList<>();
        if (root != null)
            q.offer(root);

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                if (i == size - 1 && node != null)
                    res.add(node.val);
                if (node.left != null)
                    q.offer(node.left);
                if (node.right != null)
                    q.offer(node.right);
            }
        }
        return res;
    }
}
