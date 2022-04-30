class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        
        Map<String, List<Pair<String, Double>>> map = new HashMap<>();
        for (int i = 0; i < equations.size(); i++) {
            String a = equations.get(i).get(0), b = equations.get(i).get(1);
            if (!map.containsKey(a)) map.put(a, new ArrayList<>());
            if (!map.containsKey(b)) map.put(b, new ArrayList<>());
            map.get(a).add(new Pair(b, values[i]));
            map.get(b).add(new Pair(a, 1 / values[i]));
        }
        
        int len = queries.size();
        double[] result = new double[len];
        Arrays.fill(result, -1.0);
        for (int i = 0; i < len; i++) {
            String a = queries.get(i).get(0), b = queries.get(i).get(1);
            if (!map.containsKey(a) || !map.containsKey(b)) continue;
            Queue<Pair<String, Double>> qq = new LinkedList<>();
            Set<String> visited = new HashSet<>();
            qq.offer(new Pair(a, 1.0));
            visited.add(a);
            while (!qq.isEmpty()) {
                Pair<String, Double> front = qq.poll();
                if (front.first.equals(b)) {
                    result[i] = front.second;
                    break;
                }
                for (Pair<String, Double> x : map.get(front.first)) {
                    if (visited.contains(x.first)) continue;
                    visited.add(x.first);
                    qq.offer(new Pair(x.first, front.second * x.second));
                }
            }
        }
        
        return result;
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