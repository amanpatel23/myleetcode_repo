class Solution {
    class Node {
        Node[] links;
        boolean isEnd;
        Node() {
            links = new Node[10];
            isEnd = false;
        }
    }
    
    private Node root;
    public List<Integer> lexicalOrder(int n) {
        root = new Node();
        for (int i = 1; i <= n; i++) {
            insert(String.valueOf(i));
        }
        List<Integer> ans = new ArrayList<>();
        getNums(root, 0, ans);
        return ans;
    }
    
    private void insert(String num) {
        Node curr = root;
        for (char c : num.toCharArray()) {
            int ascii = c - '0';
            if (curr.links[ascii] == null)
                curr.links[ascii] = new Node();
            curr = curr.links[ascii];
        }
        curr.isEnd = true;
    }
    
    private void getNums(Node curr, int num, List<Integer> list) {
        if (curr.isEnd) list.add(num);
        for (int i = 0; i < 10; i++) {
            if (curr.links[i] != null) {
                getNums(curr.links[i], (num * 10) + i, list);
            }
        }
    }
}