class Solution {
    public int[] sumPrefixScores(String[] words) {
        
        int n = words.length;
        Trie tt = new Trie();
        for (String str : words) tt.insert(str);
        
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            ans[i] = tt.getCnt(words[i]);
        }
        return ans;
    }
    
    class Node {
        Node[] links;
        int cntPrefix;
        Node() {
            links = new Node[26];
            cntPrefix = 0;
        }

        boolean containsKey(char c) {
            return (links[c - 'a'] != null);
        }

        void put(char c, Node node) {
            links[c - 'a'] = node;
        }

        Node get(char c) {
            return links[c - 'a'];
        }

        void increasePrefix() {
            cntPrefix++;
        }
        
        int getPrefix() {
            return cntPrefix;
        }
    }

    class Trie {

        Node root;
        Trie() {
            root = new Node();
        }

        void insert(String word) {
            Node temp = root;
            for (char c : word.toCharArray()) {
                if (!temp.containsKey(c)) {
                    temp.put(c, new Node());
                }
                temp = temp.get(c);
                temp.increasePrefix();
            }
        }

        int getCnt(String word) {
            Node temp = root;
            int sum = 0;
            for (char c : word.toCharArray()) {
                temp = temp.get(c);
                sum += temp.getPrefix();
            }
            return sum;
        }
    }
}