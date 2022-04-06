class Solution {
    
    private static final int iMax = (int) (1e9 + 100);
    private static List<List<int[]>> adjList;
    public int networkDelayTime(int[][] times, int n, int k) {
        
        adjList = new ArrayList<>();
        for (int i = 0; i <= n; i++) adjList.add(new ArrayList<>());
        for (int[] arr : times) adjList.get(arr[0]).add(new int[]{arr[1], arr[2]});
        
        int[] timeTaken = dijkstras(k, n);
        int ans = 0;
        for (int i = 1; i <= n; i++) ans = Math.max(ans, timeTaken[i]);
        return (ans == iMax ? -1 : ans);
    }
    
    private static int[] dijkstras(int src, int n) {
        
        int[] dist = new int[n + 1];
        Arrays.fill(dist, iMax);
        dist[src] = 0;
        boolean[] visited = new boolean[n + 1];
        
        Queue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(x -> x[1]));
        pq.offer(new int[]{src, 0});
        while (!pq.isEmpty()) {
            
            int[] front = pq.poll();
            if (dist[front[0]] < front[1]) continue;
            visited[front[0]] = true;
            
            for (int[] x : adjList.get(front[0])) {
                if (!visited[x[0]] && (dist[x[0]] > dist[front[0]] + x[1])) {
                    dist[x[0]] = dist[front[0]] + x[1];
                    pq.offer(new int[]{x[0], dist[x[0]]});
                }
            }
        }
        
        return dist;
    }
}