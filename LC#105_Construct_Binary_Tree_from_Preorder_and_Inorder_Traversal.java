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
    
    private static int i, n;
    private static Map<Integer, Integer> map;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        
        n = preorder.length;
        i = -1;
        map = new HashMap<>();
        for (int ii = 0; ii < n; ii++) {
            map.put(inorder[ii], ii);
        }
        
        return solve(0, n - 1, preorder);
    }
    
    private static TreeNode solve(int l, int r, int[] preorder) {
        
        if (l > r || l < 0 || r >= n) return null;
        int curr = preorder[++i];
        int idx = map.get(curr);
        TreeNode node = new TreeNode(curr);
        node.left = solve(l, idx - 1, preorder);
        node.right = solve(idx + 1, r, preorder);
        
        return node;
    }
}