class Solution {
    public int[] findRedundantDirectedConnection(int[][] edges) {
        
        int n = edges.length;
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i <= n; i++) adjList.add(new ArrayList<>());
        for (int[] arr : edges) adjList.get(arr[0]).add(arr[1]);
        
        for (int i = (n - 1); i >= 0; i--) {
            int[] indegrees = new int[n + 1];
            for (int j = 0; j < n; j++) {
                if (i == j) continue;
                indegrees[edges[j][1]]++;
            }
            
            Queue<Integer> qq = new LinkedList<>();
            for (int j = 1; j <= n; j++) {
                if (indegrees[j] == 0) {
                    qq.offer(j);
                    break;
                }
            }
            int cnt = 0;
            while (!qq.isEmpty()) {
                int front = qq.poll();
                cnt++;
                for (int x : adjList.get(front)) {
                    if (front == edges[i][0] && x == edges[i][1]) continue;
                    if (--indegrees[x] == 0) qq.offer(x);
                }
            }
            if (cnt == n) return edges[i];
        }
        
        return new int[]{};
    }
}