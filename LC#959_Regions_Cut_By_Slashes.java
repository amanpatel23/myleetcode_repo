class Solution {
    public int regionsBySlashes(String[] grid) {
        
        int n = grid.length;
        
        int len = (n + 1) * (n + 1);
        UnionFind uf = new UnionFind(len);
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 || j == 0 || i == n || j == n) {
                    int idx = ((n + 1) * i) + j;
                    uf.union(0, idx);
                }
            }
        }
        
        int ans = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i].charAt(j) == ' ') continue;
                if (grid[i].charAt(j) == '/') {
                    int idx1 = ((n + 1) * i) + (j + 1);
                    int idx2 = ((n + 1) * (i + 1)) + j;
                    if (uf.find(idx1) == uf.find(idx2)) ans++;
                    else uf.union(idx1, idx2);
                }else {
                    int idx1 = ((n + 1) * i) + j;
                    int idx2 = ((n + 1) * (i + 1)) + (j + 1);
                    if (uf.find(idx1) == uf.find(idx2)) ans++;
                    else uf.union(idx1, idx2);
                }
            }
        }
        
        return ans;
    }
    
    private static class UnionFind {

        private final int[] parent;
        private final int[] rank;

        UnionFind(int n) {
            parent = new int[n + 5];
            rank = new int[n + 5];
            for (int i = 0; i <= n; i++) {
                parent[i] = i;
                rank[i] = 0;
            }
        }

        private int find(int i) {
            if (parent[i] == i)
                return i;
            return parent[i] = find(parent[i]);
        }

        private void union(int a, int b) {
            a = find(a);
            b = find(b);
            if (a != b) {
                if (rank[a] < rank[b]) {
                    int temp = a;
                    a = b;
                    b = temp;
                }
                parent[b] = a;
                if (rank[a] == rank[b])
                    rank[a]++;
            }
        }
    }
}

