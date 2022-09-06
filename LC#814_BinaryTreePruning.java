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
    public TreeNode pruneTree(TreeNode root) {
        if (!solve(root)) return null;
        return root;
    }
    
    private static boolean solve(TreeNode node) {
        if (node == null) return false;
        boolean left = solve(node.left);
        boolean right = solve(node.right);
        if (!left) node.left = null;
        if (!right) node.right = null;
        return (left|| right || (node.val == 1));
    }
}