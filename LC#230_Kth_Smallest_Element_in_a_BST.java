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
    
    private static int cnt, ans;
    public int kthSmallest(TreeNode root, int k) {
        
        cnt = 1;
        solve(root, k);
        return ans;
    }
    
    private static void solve(TreeNode node, int k) {
        if (node != null) {
            solve(node.left, k);
            if (cnt == k) ans = node.val;
            cnt++;
            solve(node.right, k);
        }
    }
}