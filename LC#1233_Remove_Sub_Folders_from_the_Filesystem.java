class Solution {
    public List<String> removeSubfolders(String[] folder) {
        
        Trie tt = new Trie();
        for (String str : folder) tt.insert(str);
        List<String> ans = new ArrayList<>();
        tt.getFolders(tt.root, "", ans);
        return ans;
    }
    
    private class Node {
        Node[] links;
        boolean isEnd, isSlash;
        Node() {
            links = new Node[26];
            isEnd = false;
            isSlash = false;
        }
    }
    
    private class Trie {
        Node root;
        Trie() {
            root = new Node();
        }
        
        private void insert(String str) {
            Node curr = root;
            for (char c : str.toCharArray()) {
                if (c == '/') {
                    curr.isSlash = true;
                    continue;
                }
                int ascii = c - 'a';
                if (curr.links[ascii] == null) 
                    curr.links[ascii] = new Node();
                curr = curr.links[ascii];
            }
            curr.isEnd = true;
        }
        
        private static void getFolders(Node curr, String str, List<String> ans) {
            if (curr.isEnd) ans.add(str);
            if (curr.isEnd && curr.isSlash) return;
            if (curr.isSlash) str += '/';
            for (int ascii = 0; ascii < 26; ascii++) {
                char c = (char) (ascii + 'a');
                if (curr.links[ascii] == null) continue;
                getFolders(curr.links[ascii], str + c, ans);
            }
        }
    }
}