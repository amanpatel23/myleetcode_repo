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
    public int deepestLeavesSum(TreeNode root) {
        int prev_level = -1;
        int ans = 0;
        Queue<TreeNode> qq1 = new LinkedList<>();
        Queue<Integer> qq2 = new LinkedList<>();
        qq1.offer(root); qq2.offer(-1);
        while (!qq1.isEmpty()) {
            TreeNode curr_node = qq1.poll();
            int curr_level = qq2.poll();
            if (curr_level == prev_level) ans += curr_node.val;
            else {
                ans = curr_node.val;
                prev_level = curr_level;
            }
            
            if (curr_node.left != null) {
                qq1.offer(curr_node.left);
                qq2.offer(curr_level + 1);
            }
            if (curr_node.right != null) {
                qq1.offer(curr_node.right);
                qq2.offer(curr_level + 1);
            }
        }
        
        return ans;
    }
}