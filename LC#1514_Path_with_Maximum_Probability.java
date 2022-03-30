class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        
        List<List<double[]>> adjList = new ArrayList<>();
        for (int i = 0; i < n; i++) adjList.add(new ArrayList<>());
        for (int i = 0; i < edges.length; i++) {
            double a = edges[i][0], b = edges[i][1], c = succProb[i];
            adjList.get((int) a).add(new double[]{b, c});
            adjList.get((int) b).add(new double[]{a, c});
        }
        
        Queue<double[]> pq = new PriorityQueue<>(Comparator.
                                                 comparingDouble(x -> -x[1]));
        double[] arr = new double[n];
        boolean[] visited = new boolean[n];
        arr[start] = 1.0;
        pq.offer(new double[]{(double) start, 1.0});
        while (!pq.isEmpty()) {
            
            double[] top = pq.poll();
            if (arr[(int) top[0]] > top[1]) continue;
            visited[(int) top[0]] = true;
            for (double[] x : adjList.get((int) top[0])) {
                if (visited[(int) x[0]]) continue;
                double temp = arr[(int) top[0]] * x[1];
                if (arr[(int) x[0]] < temp) {
                    arr[(int) x[0]] = temp;
                    pq.offer(new double[]{x[0], temp});
                }
            }
        }
        
        return arr[end];
    }
}