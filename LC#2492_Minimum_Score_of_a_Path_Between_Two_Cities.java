class Solution {
    
    private int ans;
    public int minScore(int n, int[][] roads) {
        List<List<int[]>> adjList = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adjList.add(new ArrayList<>());
        }
        
        for (int[] arr : roads) {
            int a = arr[0], b = arr[1], c = arr[2];
            adjList.get(a).add(new int[]{b, c});
            adjList.get(b).add(new int[]{a, c});
        }
        
        boolean[] vis = new boolean[n + 1];
        ans = (int) (1e7);
        dfs(1, adjList, vis);
        
        return ans;
    }
    
    private void dfs(int curr, List<List<int[]>> adjList, boolean[] vis) {
        vis[curr] = true;
        for (int[] xx : adjList.get(curr)) {
            ans = Math.min(ans, xx[1]);
            if (vis[xx[0]]) continue;
            dfs(xx[0], adjList, vis);
        }
    }
}