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

// 1

// 2. 3

//      4
// m = 2
// c =2
// 4

class Solution {
    public int maxDepth(TreeNode root) {
        if (root == null)
            return 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        int depth = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            

            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                if (node.left != null) {
                    q.offer(node.left);
                }
                if (node.right != null) {
                    q.offer(node.right);
                }
            }

            depth++;
        }
        return depth;
    }
    /**
        int maxHeight = 0;
        public int maxDepth(TreeNode root) {
            if(root == null) {
                return 0;
            }
            maxHeight = Math.max(maxDepth(root.left), maxDepth(root.right))+1;

            return maxHeight;
        }

        *
     */
}
