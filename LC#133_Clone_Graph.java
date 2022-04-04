/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        
        if (node == null) return null;
        Map<Integer, Node> visited_nodes = new HashMap<>();
        return solve(node, visited_nodes);
    }
    
    private static Node solve(Node curr_node, Map<Integer, Node> visited_nodes) {
        
        int _val = curr_node.val;
        ArrayList<Node> _neighbors = new ArrayList<>();
        Node cloned_node = new Node(_val, _neighbors);
        visited_nodes.put(_val, cloned_node);
        for (Node x : curr_node.neighbors) {
            if (visited_nodes.containsKey(x.val))
                cloned_node.neighbors.add(visited_nodes.get(x.val));
            else
                cloned_node.neighbors.add(solve(x, visited_nodes));
        }
        
        return cloned_node;
    }
}