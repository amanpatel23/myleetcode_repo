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

        private static Triple[] info;
        private static final int maxV = (int) (1e5);

        public String getDirections(TreeNode root, int startValue, int destValue) {

            info = new Triple[maxV + 5];
            dfs(root, -1, -1, 0);

            int min_ht_node = (info[startValue].z <= info[destValue].z ? startValue : destValue);
            int max_ht_node = (min_ht_node == startValue ? destValue : startValue);

            while (info[min_ht_node].z != info[max_ht_node].z) {
                max_ht_node = info[max_ht_node].x;
            }

            while (min_ht_node != max_ht_node) {
                min_ht_node = info[min_ht_node].x;
                max_ht_node = info[max_ht_node].x;
            }

            int common_root = min_ht_node;

            StringBuilder result = new StringBuilder();
            int src_commonRoot = info[startValue].z - info[common_root].z;
            result.append("U".repeat(Math.max(0, src_commonRoot)));

            StringBuilder temp = new StringBuilder();
            while (destValue != common_root) {
                temp.append((info[destValue].y == 0) ? "L" : "R");
                destValue = info[destValue].x;
            }

            result.append(temp.reverse());
            return result.toString();
        }

        private static void dfs(TreeNode node, int parent, int dir, int height) {

            if (node == null)
                return;
            info[node.val] = new Triple(parent, dir, height);
            dfs(node.left, node.val, 0, height + 1);
            dfs(node.right, node.val, 1, height + 1);
        }

        private static class Triple {
            int x, y, z;

            Triple(int x, int y, int z) {
                this.x = x;
                this.y = y;
                this.z = z;
            }
        }
    }