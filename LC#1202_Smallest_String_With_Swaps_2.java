class Solution {
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {

        int n = s.length();
        UnionFind uf = new UnionFind(n);
        for (List<Integer> x : pairs) uf.union(x.get(0), x.get(1));
        Map<Integer, Queue<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int p = uf.find(i);
            if (!map.containsKey(p))
                map.put(p, new PriorityQueue<>(
                    Comparator.comparingInt(idx -> s.charAt(idx))));
            map.get(p).offer(i);
        }
        
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < n; i++) {
            result.append(s.charAt(map.get(uf.find(i)).poll()));
        }
        return result.toString();
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