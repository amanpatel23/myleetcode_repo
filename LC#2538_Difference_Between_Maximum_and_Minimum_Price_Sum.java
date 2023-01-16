class Solution {
    public long maxOutput(int n, int[][] edges, int[] price) {
        
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int[] arr : edges) {
            adjList.get(arr[0]).add(arr[1]);
            adjList.get(arr[1]).add(arr[0]);
        }
        
        Map<Pair<Integer, Integer>, Long> dp = new HashMap<>();
        long ans = 0;
        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, dfs(adjList, dp, price, i, -1) - price[i]);
        }
        return ans;
    }
    
    private long dfs(List<List<Integer>> adjList, 
                    Map<Pair<Integer, Integer>, Long> dp, 
                   int[] price, int node, int par) {
        
        Pair<Integer, Integer> pair = new Pair<>(node, par);
        if (dp.containsKey(pair)) {
            return dp.get(pair);
        }
        
        long ans = 0;
        for (int xx : adjList.get(node)) {
            if (xx == par) continue;
            ans = Math.max(ans, dfs(adjList, dp, price, xx, node));
        }
        
        dp.put(pair, ans + price[node]);
        return (ans + price[node]);
    }
    
    class Pair<U, V> {

        private final U first;
        private final V second;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair<?, ?> pair = (Pair<?, ?>) o;
            return first.equals(pair.first) && second.equals(pair.second);
        }

        @Override
        public int hashCode() {
            return Objects.hash(first, second);
        }

        @Override
        public String toString() {
            return "(" + first + ", " + second + ")";
        }

        private Pair(U ff, V ss) {
            this.first = ff;
            this.second = ss;
        }
    }
}