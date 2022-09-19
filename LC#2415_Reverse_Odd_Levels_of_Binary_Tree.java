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
    public TreeNode reverseOddLevels(TreeNode root) {
        
        List<List<Integer>> list = new ArrayList<>();
        Queue<TreeNode> qq = new LinkedList<>();
        qq.add(root);
        int level = 0;
        while (!qq.isEmpty()) {
            int size = qq.size();
            List<Integer> curr = new ArrayList<>();
            while (size-- > 0) {
                TreeNode front = qq.poll();
                curr.add(front.val);
                if (front.left != null) {
                    qq.add(front.left);
                    qq.add(front.right);
                }
            }
            if ((level & 1) == 1) {
                Collections.reverse(curr);
            }
            list.add(curr);
            level++;
        }
        
        TreeNode head = new TreeNode(list.get(0).get(0));
        TreeNode temp;
        qq.add(head);
        for (int i = 1; i < list.size(); i++) {
            int size = qq.size();
            int idx = 0;
            while (size-- > 0) {
                TreeNode front = qq.poll();
                front.left = new TreeNode(list.get(i).get(idx++));
                front.right = new TreeNode(list.get(i).get(idx++));
                qq.add(front.left);
                qq.add(front.right);
            }
        }
        
        return head;
    }
}