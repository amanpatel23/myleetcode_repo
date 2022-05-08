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
    
    private static int cnt;
    public int averageOfSubtree(TreeNode root) {
        
        cnt = 0;
        solve(root);
        return cnt;
    }
    
    private static int[] solve(TreeNode root) {
        if (root == null) return new int[]{0, 0};
        int[] ans = new int[]{root.val, 1};
        int[] left = solve(root.left);
        int[] right = solve(root.right);
        ans[0] += (left[0] + right[0]);
        ans[1] += (left[1] + right[1]);
        if ((ans[0] / ans[1]) == root.val) cnt++;
        return ans;
    }
}