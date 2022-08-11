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
    public boolean isValidBST(TreeNode root) {
        return solve(root, (long) (-1e15), (long) (1e15));
    }
    
    private static boolean solve(TreeNode node, long ff, long ss) {
        if (node == null) return true;
        if (node.val <= ff || node.val >= ss || !solve(node.left, ff, node.val) || 
           !solve(node.right, node.val, ss)) return false;
        return true;
    }
}