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
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if (depth == 1) {
            TreeNode n_root = new TreeNode(val);
            n_root.left = root;
            return n_root;
        }
        solve(root, 1, val, depth);
        return root;
    }
    
    private void solve(TreeNode curr, int level, int val, int depth) {
        if (curr == null) return;
        if (level == depth - 1) {
            TreeNode prevleft = curr.left, prevright = curr.right;
            TreeNode n_node_left = new TreeNode(val), n_node_right = new TreeNode(val);
            curr.left = n_node_left;
            curr.right = n_node_right;
            n_node_left.left = prevleft;
            n_node_right.right = prevright;
            return;
        }
        solve(curr.left, level + 1, val, depth);
        solve(curr.right, level + 1, val, depth);
    }
}