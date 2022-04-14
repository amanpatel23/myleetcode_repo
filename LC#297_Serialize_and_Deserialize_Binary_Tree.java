/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    private static final int N = 1001;
    public String serialize(TreeNode root) {
        
        StringBuilder preorder = new StringBuilder();
        preorder_traversal(root, preorder);
        return preorder.toString();
    }

    private static void preorder_traversal(TreeNode node, StringBuilder preorder) {
        
        if (node == null) {
            preorder.append(N).append(" ");
            return;
        }
        preorder.append(node.val).append(" ");
        preorder_traversal(node.left, preorder);
        preorder_traversal(node.right, preorder);
    }
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        
        Queue<String> qq = new LinkedList<>(Arrays.asList(data.split(" ")));
        return buildTree(qq);                                 
    }
    
    private static TreeNode buildTree(Queue<String> qq) {
        
        int front = Integer.parseInt(qq.poll());
        if (front == 1001) return null;
        TreeNode node = new TreeNode(front);
        node.left = buildTree(qq);
        node.right = buildTree(qq);
        return node;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));