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
    public String getDirections(TreeNode root, int startValue, int destValue) {
        
        StringBuilder rootToStart = new StringBuilder();
        StringBuilder rootToDest = new StringBuilder();
        
        getPath(root, startValue, rootToStart);
        getPath(root, destValue, rootToDest);
        
        rootToStart.reverse();
        rootToDest.reverse();
        
        int n1 = rootToStart.length(), n2 = rootToDest.length();
        StringBuilder result = new StringBuilder();
        int idx = 0;
        for (idx = 0; idx < Math.min(n1, n2); idx++) {
            if (rootToStart.charAt(idx) != rootToDest.charAt(idx))
                break;
        }
        
        return result.append("U".repeat(n1 - idx)).
            append(rootToDest.substring(idx)).toString();
    }
    
    private static boolean getPath(TreeNode node, int val, StringBuilder path) {
        
        if (node ==  null)
            return false;
        
        if (node.val == val)
            return true;
        
        if (getPath(node.left, val, path)) {
            path.append("L");
            return true;
        }
        else if (getPath(node.right, val, path)) {
            path.append("R");
            return true;
        }
        
        return false;
    }
}