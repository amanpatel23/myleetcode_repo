class Solution {
    public boolean validateBinaryTreeNodes(int n, int[] left, int[] right) {
        
        UnionFind uf = new UnionFind(n);
        int[] indegrees = new int[n];
        for (int i = 0; i < n; i++) {
            if (left[i] != -1) { 
                indegrees[left[i]]++;
                uf.union(i, left[i]);
            }
            if (right[i] != -1) { 
                indegrees[right[i]]++;
                uf.union(i, right[i]);
            }
        }
        
        Set<Integer> set = new HashSet<>();
        int zero_indegree = 0, one_indegree = 0;
        for (int i = 0; i < n; i++) {
            set.add(uf.find(i));
            if (indegrees[i] == 0) { 
                zero_indegree++;
            }
            else if (indegrees[i] == 1) one_indegree++;
        }
        
        return (set.size() == 1 && zero_indegree == 1 && one_indegree == n - 1);
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