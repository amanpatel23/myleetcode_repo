class Solution {
    
    private static final int iMax = (int) (1e9);
    private static List<List<Pair>> adjList;
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        
        adjList = new ArrayList<>();
        for (int i = 0; i < n; i++) adjList.add(new ArrayList<>());
        for (int[] flight : flights) {
            adjList.get(flight[0]).add(new Pair(flight[1], flight[2]));
        }
        
        int[][] dist = dijkstras(n, flights, src, k);
        int min_cost = iMax;
        for (int i = 0; i <= k; i++) min_cost = Math.min(min_cost, dist[dst][i]);
        
        return (min_cost == iMax) ? -1 : min_cost;
    }
    
    private static int[][] dijkstras(int n, int[][] flights, int src, int k) {

        int[][] dist = new int[n][k + 1];
        for (int[] row : dist) Arrays.fill(row, iMax);
        for (int i = 0; i <= k; i++) dist[src][i] = 0;

        Comparator<Triplet> myComp = Comparator.comparingInt(o -> o.a);
        Queue<Triplet> pq = new PriorityQueue<>(myComp);
        pq.add(new Triplet(0, src, 0));
        while (!pq.isEmpty()) {

            Triplet top = pq.poll();
            int node = top.b, weight = top.a, steps = top.c;
            if (dist[node][Math.max(steps - 1, 0)] < weight || steps > k) continue;

            for (Pair x : adjList.get(node)) {
                int wt = dist[node][Math.max(0, steps - 1)] + x.b;
                if (wt < dist[x.a][steps]) {
                    dist[x.a][steps] = wt;
                    pq.offer(new Triplet(wt, x.a, steps + 1));
                }
            }
        }

        return dist;
    }
    
    private static class Triplet {
        int a, b, c;
        Triplet(int a, int b, int c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }
    }
    
    private static class Pair {
        int a, b;
        Pair (int a, int b) {
            this.a = a;
            this.b = b;
        }
    }
}