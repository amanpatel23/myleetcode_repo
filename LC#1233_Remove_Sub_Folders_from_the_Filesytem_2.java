class Solution {
    public List<String> removeSubfolders(String[] folder) {
        
        Node root = new Node();
        int n = folder.length;
        for (int i = 0; i < n; i++) {
            Node curr = root;
            String str = folder[i];
            for (char c : str.toCharArray()) {
                int ascii = (c == '/') ? 26 : (c - 'a');
                if (curr.links[ascii] == null)
                    curr.links[ascii] = new Node();
                curr = curr.links[ascii];
            }
            curr.endIdx = i;
        }
        
        List<String> ans = new ArrayList<>();
        Queue<Node> qq = new LinkedList<>();
        qq.add(root);
        while (!qq.isEmpty()) {
            Node front = qq.poll();
            if (front.endIdx >= 0) ans.add(folder[front.endIdx]);
            if (front.endIdx >= 0 && front.links[26] != null) continue;
            for (int i = 0; i < 27; i++) {
                if (front.links[i] == null) continue;
                qq.add(front.links[i]);
            }
        }
        return ans;
    }
    
    private class Node {
        Node[] links;
        int endIdx;
        Node() {
            links = new Node[27];
            endIdx = -1;
        }
    }
}