class Solution {
    public int[] findRedundantDirectedConnection(int[][] edges) {
        
        int n = edges.length;
        int[] indegrees = new int[n + 1];
        int[] edge1 = new int[]{-1, -1}, edge2 = new int[]{-1, -1};
        for (int[] arr : edges) {
            if (indegrees[arr[1]] > 0) {
                edge1[0] = indegrees[arr[1]]; edge1[1] = arr[1];
                edge2[0] = arr[0]; edge2[1] = arr[1];
                break;
            }
            indegrees[arr[1]] = arr[0];
        }
        
        UnionFind uf = new UnionFind(n + 1);
        if (edge1[0] == -1) {
            for (int[] arr : edges) {
                if (uf.find(arr[0]) == uf.find(arr[1])) return arr;
                uf.union(arr[0], arr[1]);
            }
        }
        
        uf = new UnionFind(n + 1);
        boolean is_edge2 = true;
        for (int[] arr : edges) {
            if (arr[0] == edge2[0] && arr[1] == edge2[1]) continue;
            if (uf.find(arr[0]) == uf.find(arr[1])) {
                is_edge2 = false;
                break;
            }
            uf.union(arr[0], arr[1]);
        }
        int[] edge_to_remove = is_edge2 ? edge2 : edge1;
        for (int[] arr : edges) {
            if (arr[0] == edge_to_remove[0] && arr[1] == edge_to_remove[1]) return arr;
        }
        
        return new int[]{};
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