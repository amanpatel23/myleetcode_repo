class Solution {
    public int numberOfGoodPaths(int[] vals, int[][] edges) {
        
        int n = vals.length;
        Arrays.sort(edges,
                Comparator.comparingInt(x -> Math.max(vals[x[0]], vals[x[1]]))
        );
        
        UnionFind uf = new UnionFind(n, vals);
        int ans = n;
        for (int[] arr : edges) {
            int p1 = uf.find(arr[0]), p2 = uf.find(arr[1]);
            if (p1 == p2) continue;
            else ans += uf.union(arr[0], arr[1]);
        }
        
        return ans;
    }
    
    private static class UnionFind {

        private final int[] parent;
        private final int[] vals;
        private final int[] freq;

        UnionFind(int n, int[] arr) {
            parent = new int[n + 5];
            vals = arr;
            freq = new int[n + 5];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                freq[i] = 1;
            }
        }

        private int find(int i) {
            if (parent[i] == i)
                return i;
            return parent[i] = find(parent[i]);
        }

        private int union(int a, int b) {
            a = find(a);
            b = find(b);
            if (a != b) {
                if (vals[a] == vals[b]) {
                    parent[b] = a;
                    int ans = freq[a] * freq[b];
                    freq[a] += freq[b];
                    return ans;
                } else if (vals[a] > vals[b]) {
                    parent[b] = a;
                    return 0;
                } else {
                    parent[a] = b;
                    return 0;
                }
            }
            return 0;
        }
    }
}