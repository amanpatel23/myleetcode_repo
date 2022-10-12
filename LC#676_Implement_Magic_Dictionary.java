class MagicDictionary {

    private class Node {
        Node[] links;
        boolean isEnd;
        Node() {
            links = new Node[26];
            isEnd = false;
        }
    }
    
    private Node root;
    public MagicDictionary() {
        root = new Node();
    }
    
    public void buildDict(String[] dictionary) {
        for (String str : dictionary) {
            insert(str);
        }
    }
    
    public boolean search(String searchWord) {
        return searchUtil(root, searchWord, 0, false);
    }
    
    private void insert(String str) {
        Node curr = root;
        for (char c : str.toCharArray()) {
            int ascii = c - 'a';
            if (curr.links[ascii] == null) 
                curr.links[ascii] = new Node();
            curr = curr.links[ascii];
        }
        curr.isEnd = true;
    }
    
    private boolean searchUtil(Node curr, String str, int i, boolean flag) {
        if (i == str.length()) 
            return (curr.isEnd && i == str.length() && flag);
        
        boolean ans = false;
        int ascii = str.charAt(i) - 'a';
        if (!flag) {
            for (int ii = 0; ii < 26; ii++) {
                if (ii == ascii || curr.links[ii] == null)
                    continue;
                if (searchUtil(curr.links[ii], str, i + 1, true)) return true;
            }
        }
        if (curr.links[ascii] != null && searchUtil(curr.links[ascii], str, i + 1, flag))
            return true;
        return false;
    }
}

/**
 * Your MagicDictionary object will be instantiated and called as such:
 * MagicDictionary obj = new MagicDictionary();
 * obj.buildDict(dictionary);
 * boolean param_2 = obj.search(searchWord);
 */