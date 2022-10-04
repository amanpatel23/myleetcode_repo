class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        
        Trie tt = new Trie();
        for (String str : products) {
            tt.insert(str);
        }
        
        String str = "";
        Node curr = tt.root;
        List<List<String>> ans = new ArrayList<>();
        boolean flag = false;
        for (char c : searchWord.toCharArray()) {
            if (flag) {
                ans.add(new ArrayList<>());
                continue;
            }
            int ascii = c - 'a';
            str += c;
            curr = curr.links[ascii];
            if (curr == null) {
                ans.add(new ArrayList<>());
                flag = true;
                continue;
            }
            List<String> list = new ArrayList<>();
            tt.getWords(curr, str, list);
            ans.add(list);
        }
        
        return ans;
    }
    
    private class Node {
        Node[] links;
        boolean flag;
        Node() {
            links = new Node[26];
            flag = false;
        }
    }
    
    private class Trie {
        Node root;
        Trie() {
            root = new Node();
        }
        
        private void insert(String str) {
            Node temp = root;
            for (char c : str.toCharArray()) {
                int ascii = c - 'a';
                if (temp.links[ascii] == null) {
                    temp.links[ascii] = new Node();
                }
                temp = temp.links[ascii];
            }
            temp.flag = true;
        }
        
        private void getWords(Node curr, String str, List<String> list) {
            if (curr.flag) {
                list.add(str);
            }
            
            for (int i = 0; i < 26; i++) {
                if (list.size() == 3) break;
                if (curr.links[i] == null) continue;
                char c = (char) (i + 'a');
                getWords(curr.links[i], str + c, list);
            }
        }
    }
}