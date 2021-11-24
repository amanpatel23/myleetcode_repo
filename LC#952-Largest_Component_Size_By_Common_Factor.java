class Solution {
    public int largestComponentSize(int[] nums) {
        
        int maxV = 0;
        for (int num: nums)
            maxV = Math.max(maxV, num);
        
        UnionFind uf = new UnionFind(maxV + 1);
        
        for (int num: nums) {
            for (int i = 2; (i * i) <= num; i++) {
                if (num % i == 0) {
                    uf.unify(num, i);
                    uf.unify(num, num / i);
                }
            }
        }
        
        Map<Integer, Integer> _map = new HashMap<>();
        int result = 0;
        for (int num: nums) {
            int parent = uf.getAbsoluteParent(num);
            _map.putIfAbsent(parent, 0);
            _map.put(parent, _map.get(parent) + 1);
            result = Math.max(result, _map.get(parent));
        }
        
        return result;
    }
    
    private static class UnionFind {

        private final int[] parent;
        UnionFind(int n) {
            parent = new int[n];
            for (int i = 0; i < n; i++)
                parent[i] = i;
        }

        private int getAbsoluteParent(int i) {
            if (parent[i] == i)
                return i;
            return parent[i] = getAbsoluteParent(parent[i]);
        }

        private void unify(int i, int j) {
            int p1 = getAbsoluteParent(i);
            int p2 = getAbsoluteParent(j);
            if (p1 != p2)
                parent[p1] = p2;
        }
    }
}