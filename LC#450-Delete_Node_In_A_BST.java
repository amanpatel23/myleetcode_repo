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
    
    private static TreeNode leftSubtree, rightSubtree;
    public TreeNode deleteNode(TreeNode root, int key) {
        
        leftSubtree = null;
        rightSubtree = null;
        
        TreeNode _root = root;
        _root = solve(_root, null, key);
        if (leftSubtree != null)
            _root = solve(_root, leftSubtree, leftSubtree.val);
        if (rightSubtree != null)
            _root = solve(_root, rightSubtree, rightSubtree.val);
        return _root;
    }
    
    private static TreeNode solve(TreeNode node, TreeNode subtree, int key) {
        
        if (node == null)
            return subtree;
        
        if (node.val == key) {
            leftSubtree = node.left;
            rightSubtree = node.right;
            return null;
        }
        
        if (node.val > key)
            node.left = solve(node.left, subtree, key);
        else
            node.right = solve(node.right, subtree, key);
        return node;
    }
}