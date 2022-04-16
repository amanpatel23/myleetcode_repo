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
    public TreeNode convertBST(TreeNode root) {
        solve(root, 0);
        return root;
    }
    
    private static int solve(TreeNode node, int to_add) {
        if (node == null) return 0;
        int right = solve(node.right, to_add);
        int left = solve(node.left, to_add + right + node.val);
        node.val += (right + to_add);
        return (node.val + left - to_add);
    }
}