class Solution {
    
    private static final int iMax = (int) (1e9);
    private static List<List<Pair>> adjList;
    private static int[][] dp;
    public int findCheapestPrice(int n, int[][] flights, int src, int dest, int k) {
        
        adjList = new ArrayList<>();
        for (int i = 0; i < n; i++) adjList.add(new ArrayList<>());
        for (int[] flight : flights) {
            adjList.get(flight[0]).add(new Pair(flight[1], flight[2]));
        }
        dp = new int[n][k + 5];
        for (int[] r : dp) Arrays.fill(r, -1);
        
        int result = solve(src, k + 1, dest);
        return (result == iMax ? -1 : result);
    }
    
    private static int solve(int curr, int edges, int dest) {
        
        if (edges < 0) return iMax;
        if (curr == dest) return 0;
        
        if (dp[curr][edges] != -1) return dp[curr][edges];
        
        int ans = iMax;
        for (Pair p : adjList.get(curr)) {
            ans = Math.min(ans, p.y + solve(p.x, edges - 1, dest));
        }
        
        return dp[curr][edges] = Math.min(ans, iMax);
    }
    
    private static class Pair {
        int x, y;
        Pair (int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}