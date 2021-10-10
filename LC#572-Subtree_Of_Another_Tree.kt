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
    fun isSubtree(root: TreeNode?, subRoot: TreeNode?): Boolean {

        if (root == null)
            return false
        
        if (root.`val` == subRoot?.`val`) {
            if (check(root, subRoot))
                return true
        }
        
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot)
    }
    
    fun check(root: TreeNode?, subRoot: TreeNode?): Boolean {
        if (root == null && subRoot == null)
            return true
        if (root == null || subRoot == null || (root.`val` != subRoot.`val`))
            return false
        
        return check(root.left, subRoot.left) && check(root.right, subRoot.right)
    }
}