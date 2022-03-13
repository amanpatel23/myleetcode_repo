class Solution {
    
    private static final long lMax = (long) (1e12);
    private static int n;
    public long minimumWeight(int _n, int[][] edges, int src1, int src2, int dest) {
        
        n = _n;
        
        List<List<Pair>> graph = new ArrayList<>();
        List<List<Pair>> rev_graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
            rev_graph.add(new ArrayList<>());
        }
        
        for (int[] x : edges) {
            addEdge(graph, x[0], x[1], x[2]);
            addEdge(rev_graph, x[1], x[0], x[2]);
        }
        
        long[] dist_from_src1 = dijkstras(graph, src1);
        long[] dist_from_src2 = dijkstras(graph, src2);
        long[] dist_from_dest = dijkstras(rev_graph, dest);
        
        long result = lMax;
        for (int i = 0; i < n; i++) {
            long curr = dist_from_src1[i] + dist_from_src2[i] + dist_from_dest[i];
            result = Math.min(result, curr);
        }
        
        return (result == lMax) ? -1 : result;
    }
    
    private static void addEdge(List<List<Pair>> g, int a, int b, int w) {
        g.get(a).add(new Pair(b, w));
    }
    
    private static class Pair {
        long ff;
        long ss;
        Pair (long ff, long ss) {
            this.ff = ff;
            this.ss = ss;
        }
    }
    
    private static long[] dijkstras(List<List<Pair>> g, int src) {
        
        boolean[] visited = new boolean[n];
        Arrays.fill(visited, false);
        
        long[] dist = new long[n];
        Arrays.fill(dist, lMax);
        dist[src] = 0;
        
        Queue<Pair> pq = new PriorityQueue<>(Comparator.comparingLong(o -> o.ff));
        pq.offer(new Pair(0, src));
        while (!pq.isEmpty()) {
            
            Pair top = pq.poll();
            int node = (int) top.ss;
            long weight = top.ff;
            
            visited[node] = true;
            if (dist[node] < weight)
                continue;
            
            for (Pair x : g.get(node)) {
                
                int xNode = (int) x.ff;
                long xWeight = x.ss;
                if (visited[xNode])
                    continue;
                
                long nWeight = dist[node] + xWeight;
                if (nWeight < dist[xNode]) {
                    dist[xNode] = nWeight;
                    pq.offer(new Pair(nWeight, xNode));
                }
            }
        }
        
        return dist;
    }
}