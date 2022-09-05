/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        
        if (root == null) return new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        Queue<Node> qq = new LinkedList<>();
        qq.add(root);
        while (!qq.isEmpty()) {
            List<Integer> temp = new ArrayList<>();
            int size = qq.size();
            while (size-- > 0) {
                Node front = qq.poll();
                temp.add(front.val);
                for (Node child : front.children) qq.add(child);
            }
            ans.add(temp);
        }
        return ans;
    }
}