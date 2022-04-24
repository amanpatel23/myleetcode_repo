class Solution {
    
    private static List<List<int[]>> adjList;
    private static int ans;
    public int maximalPathQuality(int[] values, int[][] edges, int maxTime) {
        
        int n = values.length;
        adjList = new ArrayList<>();
        for (int i = 0; i < n; i++) adjList.add(new ArrayList<>());
        for (int[] arr : edges) {
            int a = arr[0], b = arr[1], c = arr[2];
            adjList.get(a).add(new int[]{b, c});
            adjList.get(b).add(new int[]{a, c});
        }
        
        ans = values[0];
        int[] visited = new int[n];
        dfs(0, visited, 0, maxTime, values);
        return ans;
    }
    
    private static void dfs(int curr, int[] visited, int score, int time_left, 
                            int[] values) {
        
        if (time_left < 0) return;
        if (visited[curr]++ == 0) score += values[curr];
        if (curr == 0) ans = Math.max(ans, score);
        for (int[] x : adjList.get(curr)) {
            dfs(x[0], visited, score, time_left - x[1], values);
        }
        --visited[curr];
    }
}