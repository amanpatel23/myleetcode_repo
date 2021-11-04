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
    public int sumOfLeftLeaves(TreeNode root) {
        
        int result = solve(root, 0, false);
        return result;
    }
    
    static int solve(TreeNode node, int sum, boolean flag) {
        
        if (node == null)
            return 0;
        
        if (node.left == null && node.right == null)
            return (sum += (flag ? (node.val) : 0));
        
        return solve(node.left, sum, true) + solve(node.right, sum, false);
    }
}