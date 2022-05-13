/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        if (root == null) return null;
        
        Node[] prev_seen = new Node[6005];
        Arrays.fill(prev_seen, null);
        Queue<Node> qq1 = new LinkedList<>();
        Queue<Integer> qq2 = new LinkedList<>();
        qq1.offer(root); qq2.offer(0);
        while (!qq1.isEmpty()) {
            Node node = qq1.poll();
            int level = qq2.poll();
            if (prev_seen[level] == null) node.next = null;
            else prev_seen[level].next = node;
            prev_seen[level] = node;
            
            if (node.left != null) {
                qq1.offer(node.left);
                qq2.offer(level + 1);
            }
            if (node.right != null) {
                qq1.offer(node.right);
                qq2.offer(level + 1);
            }
        }
        
        return root;
    }
}