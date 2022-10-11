class Trie {
    
    class Node {
        Node[] links;
        boolean isEnd;
        Node() {
            links = new Node[26];
            isEnd = false;
        }
    }

    Node root;
    public Trie() {
        root = new Node();
    }
    
    public void insert(String word) {
        Node curr = root;
        for (char c : word.toCharArray()) {
            int ascii = c - 'a';
            if (curr.links[ascii] == null)
                curr.links[ascii] = new Node();
            curr = curr.links[ascii];
        }
        curr.isEnd = true;
    }
    
    public boolean search(String word) {
        Node curr = root;
        for (char c : word.toCharArray()) {
            int ascii = c - 'a';
            if (curr.links[ascii] == null) return false;
            curr = curr.links[ascii];
        }
        return curr.isEnd;
    }
    
    public boolean startsWith(String prefix) {
        Node curr = root;
        for (char c : prefix.toCharArray()) {
            int ascii = c - 'a';
            if (curr.links[ascii] == null) return false;
            curr = curr.links[ascii];
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */