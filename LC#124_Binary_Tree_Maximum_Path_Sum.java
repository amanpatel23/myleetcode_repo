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
    private int ans;
    public int maxPathSum(TreeNode root) {
        ans = (int) (-1e8);
        helper(root);
        return ans;
    }
    
    private int helper(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        int leftSum = helper(root.left);
        int rightSum = helper(root.right);
        
        int curr = root.val;
        if (leftSum >= 0) curr += leftSum;
        if (rightSum >= 0) curr += rightSum;
        
        ans = Math.max(ans, curr);
        
        int temp = root.val + Math.max(leftSum, rightSum);
        return Math.max(temp, 0);
    }
}