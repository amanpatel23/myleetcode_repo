class Solution {
    
    private final int[][] dir = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    
    class UnionFind {
        int[] parent;
        int[] rank;
        UnionFind(int size) {
            parent = new int[size];
            rank = new int[size];
            for (int i = 0; i < size; i++) {
                parent[i] = i;
            }
            Arrays.fill(rank, 1);
        }
        
        int find(int i) {
            if (parent[i] == i) return i;
            return parent[i] = find(parent[i]);
        }
        
        void union(int a, int b) {
            if (rank[a] < rank[b]) {
                int temp = a;
                a = b;
                b = temp;
            }
            parent[b] = a;
            rank[a] += rank[b];
        }
    }
    
    public int[] maxPoints(int[][] grid, int[] queries) {
        
        int m = grid.length, n = grid[0].length;
        int qLen = queries.length;
        
        
        Queue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(x -> x[0]));
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                pq.add(new int[]{grid[i][j], i, j});
            }
        }
        
        boolean[][] vis = new boolean[m][n];
        
        List<Integer> sortedQueries = new ArrayList<>();
        for (int i = 0; i < qLen; i++) {
            sortedQueries.add(i);
        }
        sortedQueries.sort(Comparator.comparingInt(i -> queries[i]));
        
        int[] ans = new int[qLen];
        
        UnionFind uf = new UnionFind(m * n);
        
        for (int ii : sortedQueries)  {
            int num = queries[ii];
            while (!pq.isEmpty() && pq.peek()[0] < num) {
                int[] top = pq.poll();
                int i = top[1], j = top[2];
                vis[i][j] = true;
                int ff = i * n + j;
                for (int[] dd : dir) {
                    int r = i + dd[0], c = j + dd[1];
                    if (r < 0 || r == m || c < 0 || c == n || !vis[r][c]) {
                        continue;
                    }
                    int ss = r * n + c;
                    int p1 = uf.find(ff), p2 = uf.find(ss);
                    if (p1 != p2) {
                        uf.union(p1, p2);
                    }
                }
            }
            if (vis[0][0]) {
                ans[ii] = uf.rank[uf.find(0)];
            }
        }
        
        return ans;
    }
}