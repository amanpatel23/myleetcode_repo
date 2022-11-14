class Solution {
    public int removeStones(int[][] stones) {
        int n = stones.length;
        UnionFind uf = new UnionFind(n);
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (stones[i][0] == stones[j][0] || stones[i][1] == stones[j][1])
                    uf.union(i, j);
            }
        }
        return uf.getAns(n);
    }
    
    private static class UnionFind {

        private final int[] parent;
        private final int[] rank;

        UnionFind(int n) {
            parent = new int[n + 5];
            rank = new int[n + 5];
            for (int i = 0; i <= n; i++) {
                parent[i] = i;
                rank[i] = 1;
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
                if (rank[a] >= rank[b]) {
                    parent[b] = a;
                    rank[a] += rank[b];
                } else {
                    parent[a] = b;
                    rank[b] += rank[a];
                }
            }
        }
        
        private int getAns(int n) {
            int ans = 0;
            Set<Integer> set = new HashSet<>();
            for (int i = 0; i < n; i++) {
                int pp = find(i);
                if (set.contains(pp)) continue;
                set.add(pp);
                ans += (rank[pp] - 1);
            }
            return ans;
        }
    }
}