class Solution {
    
    private class Node {
        Node[] links;
        Node() {
            links = new Node[2];
        }
    }
    
    private Node root;
    private int ans;
    public int findMaximumXOR(int[] nums) {
        root = new Node();
        ans = 0;
        for (int num : nums) 
            insert(num);
        for (int num : nums) 
            getMax(root, 31, num);
        return ans;
    }
    
    private void insert(int num) {
        Node curr = root;
        for (int pos = 31; pos >= 0; pos--) {
            int idx = (num >> pos) & 1;
            if (curr.links[idx] == null) 
                curr.links[idx] = new Node();
            curr = curr.links[idx];
        }
    }
    
    private void getMax(Node currNode, int pos, int num) {
        if (pos == -1) {
            ans = Math.max(ans, num);
            return;
        }
        
        int bit = (num >> pos) & 1;
        if (currNode.links[bit ^ 1] != null) 
            getMax(currNode.links[bit ^ 1], pos - 1, num | (1 << pos));
        else
            getMax(currNode.links[bit], pos - 1, num & ~(1 << pos));
    }
}