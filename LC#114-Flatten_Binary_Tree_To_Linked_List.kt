/**
 * Example:
 * var ti = TreeNode(5)
 * var v = ti.`val`
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    fun flatten(root: TreeNode?): Unit {

        val nodes = mutableListOf<TreeNode>()

        fun preorder(root: TreeNode?) {
            if (root == null)
                return

            nodes.add(root)
            preorder(root.left)
            preorder(root.right)
        }

        preorder(root)

        val n = nodes.size
        for (i in 0 until (n - 1)) {
            nodes[i].left = null
            nodes[i].right = nodes[i + 1]
        }
    }
}