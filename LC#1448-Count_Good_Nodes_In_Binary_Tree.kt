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
    
    val iMin = (-1e9).toInt()
    fun goodNodes(root: TreeNode?): Int {
        
        val result = goodNodesUtil(root, iMin)
        return result
    }
    
    fun goodNodesUtil(node: TreeNode?, maxTil: Int): Int {
        
        if (node == null)
            return 0
        
        return (if (node.`val` >= maxTil) 1 else 0) + 
                goodNodesUtil(node.left, maxOf(maxTil, node.`val`)) +
                goodNodesUtil(node.right, maxOf(maxTil, node.`val`))
    }
}