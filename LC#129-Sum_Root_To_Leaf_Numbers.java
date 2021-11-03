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
    public int sumNumbers(TreeNode root) {
        
        int result = solve(root, 0);
        return result;
    }
    
    static int solve(TreeNode node, int sum) {
        
        if (node.left == null && node.right == null)
            return ((sum * 10) + node.val);
        
        if (node.right == null)
            return solve(node.left, (sum * 10) + node.val);
        
        if (node.left == null)
            return solve(node.right, (sum * 10) + node.val);
        
        return solve(node.left, (sum * 10) + node.val) + 
                solve(node.right, (sum * 10) + node.val);
    }
}