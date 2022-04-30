class Solution {
    
    private static Map<String, List<Pair<String, Double>>> adjMap;
    public double[] calcEquation(List<List<String>> equations, double[] values, 
                                 List<List<String>> queries) {
        
        adjMap = new HashMap<>();
        for (int i = 0; i < equations.size(); i++) {
            String a = equations.get(i).get(0), b = equations.get(i).get(1);
            if (!adjMap.containsKey(a)) adjMap.put(a, new ArrayList<>());
            if (!adjMap.containsKey(b)) adjMap.put(b, new ArrayList<>());
            adjMap.get(a).add(new Pair(b, values[i]));
            adjMap.get(b).add(new Pair(a, 1 / values[i]));
        }
        
        int len = queries.size();
        double[] result = new double[len];
        Arrays.fill(result, -1.0);
        for (int i = 0; i < len; i++) {
            Set<String> visited = new HashSet<>();
            String a = queries.get(i).get(0), b = queries.get(i).get(1);
            if (!adjMap.containsKey(a) || !adjMap.containsKey(b)) continue;
            dfs(a, b, 1.0, visited, result, i);
        }
        
        return result;
    }
    
    private static void dfs(String curr, String target, double ans, Set<String> visited, 
                            double[] result, int idx) {
        if (curr.equals(target)) {
            result[idx] = ans;
            return;
        }
        
        visited.add(curr);
        for (Pair<String, Double> x : adjMap.get(curr)) {
            if (visited.contains(x.first)) continue;
            dfs(x.first, target, ans * x.second, visited, result, idx);
        }
    }
    
    private static class Pair<U, V> {

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