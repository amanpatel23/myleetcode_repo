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
    
    private int result;
    public int findTilt(TreeNode root) {
        
        solve(root);
        return result;
    }
    
    private int solve(TreeNode node) {
        
        if (node == null)
            return 0;
        
        int left_sum = solve(node.left);
        int right_sum = solve(node.right);
        
        result += Math.abs(left_sum - right_sum);
        return (left_sum + right_sum + node.val);
    }
}