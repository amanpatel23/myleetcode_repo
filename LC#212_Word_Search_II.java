class Solution {
    private final int[][] dir = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    private int m, n;
    private List<String> ans;
    public List<String> findWords(char[][] board, String[] words) {
        m = board.length; n = board[0].length;
        TrieNode root = insert(words);
        ans = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dfs(root, i, j, board);
            }
        }
        return ans;
    }
    
    private void dfs(TrieNode curr, int i, int j, char[][] board) {
        if (curr.endStr != null) {
            ans.add(curr.endStr);
            curr.endStr = null;
        }
        if (i < 0 || i == m || j < 0 || j == n || board[i][j] == '#') return;
        char ch = board[i][j];
        if (curr.links[ch - 'a'] == null) return;
        board[i][j] = '#';
        for (int[] dd : dir) {
            int rr = i + dd[0], cc = j + dd[1];
            dfs(curr.links[ch - 'a'], rr, cc, board);
        }
        board[i][j] = ch;
    }
    
    private TrieNode insert(String[] words) {
        TrieNode root = new TrieNode();
        for (String ww : words) {
            TrieNode curr = root;
            for (char c : ww.toCharArray()) {
                int ascii = c - 'a';
                if (curr.links[ascii] == null) 
                    curr.links[ascii] = new TrieNode();
                curr = curr.links[ascii];
            }
            curr.endStr = ww;
        }
        return root;
    }
    
    private class TrieNode {
        TrieNode[] links;
        String endStr;
        TrieNode() {
            links = new TrieNode[26];
            endStr = null;
        }
    }
}