class Solution {
    public int networkBecomesIdle(int[][] edges, int[] patience) {
        
        int n = patience.length;
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < n; i++) adjList.add(new ArrayList<>());
        for (int[] arr : edges) { 
            adjList.get(arr[0]).add(arr[1]);
            adjList.get(arr[1]).add(arr[0]);
        }
        
        int[] dist = new int[n];
        Arrays.fill(dist, -1);
        dist[0] = 0;
        Queue<int[]> qq = new LinkedList<>();
        qq.offer(new int[]{0, 0});
        while(!qq.isEmpty()) {
            
            int[] front = qq.poll();
            for (int x : adjList.get(front[0])) {
                if (dist[x] == -1) {
                    dist[x] = front[1] + 1;
                    qq.offer(new int[]{x, dist[x]});
                }
            }
        }
        
        int ans = 0;
        for (int i = 1; i < n; i++) {
            if (dist[i] == -1) continue;
            int div = ((2 * dist[i]) - 1) / patience[i];
            ans = Math.max(ans, (patience[i] * div) + (2 * dist[i]) + 1);
        }
        return ans;
    }
}