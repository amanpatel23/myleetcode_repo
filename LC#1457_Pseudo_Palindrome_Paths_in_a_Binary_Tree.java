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
    private static int ans;
    public int pseudoPalindromicPaths (TreeNode root) {
        ans = 0;
        solve(root, 0);
        return ans;
    }
    
    private static TreeNode solve(TreeNode node, int mask) {
        if (node == null) return null;
        mask = mask ^ (1 << node.val);
        TreeNode left = solve(node.left, mask);
        TreeNode right = solve(node.right, mask);
        if (left == null && right == null && noOfSetBits(mask) <= 1) ans++;
        return node;
    }
    
    private static int noOfSetBits(long x) {
        int cnt = 0;
        while (x != 0) {
            x = x & (x - 1);
            cnt++;
        }
        return cnt;
    }
}