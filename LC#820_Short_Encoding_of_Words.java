class Solution {
    private Node root;
    public int minimumLengthEncoding(String[] words) {
        root = new Node();
        Arrays.sort(words, (o1, o2) -> (o2.length() - o1.length()));
        int ans = 0;
        for (String str : words) {
            if (isPrefix(str)) continue;
            ans += (str.length() + 1);
            insert(str);
        }
        return ans;
    }
    
    private class Node {
        Node[] links;
        Node() {
            links = new Node[26];
        }
    }
    
    private void insert(String str) {
        Node curr = root;
        for (int i = str.length() - 1; i >= 0; i--) {
            int ascii = str.charAt(i) - 'a';
            if (curr.links[ascii] == null) 
                curr.links[ascii] = new Node();
            curr = curr.links[ascii];
        }
    }
    
    private boolean isPrefix(String str) {
        Node curr = root;
        for (int i = str.length() - 1; i >= 0; i--) {
            int ascii = str.charAt(i) - 'a';
            if (curr.links[ascii] == null) return false;
            curr = curr.links[ascii];
        }
        return true;
    }
}