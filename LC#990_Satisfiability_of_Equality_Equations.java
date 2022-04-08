class Solution {
    public boolean equationsPossible(String[] equations) {
        
        List<int[]> notMatching = new ArrayList<>();
        UnionFind uf = new UnionFind(26);
        for (String str : equations) {
            int ff = str.charAt(0) - 'a', ss = str.charAt(3) - 'a';
            char sign = str.charAt(1);
            if (sign == '=') uf.union(ff, ss);
            else notMatching.add(new int[]{ff, ss});
        }
        
        for (int[] arr : notMatching) {
            if (uf.find(arr[0]) == uf.find(arr[1])) return false;
        }
        return true;
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