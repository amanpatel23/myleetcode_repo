class Solution {
    
    private static int[][] dp;
    public int minSteps(int n) {
        
        dp = new int[n + 1][n + 1];
        for (int i = 0; i <= n; i++)
            Arrays.fill(dp[i], -1);
        
        int result = solve(0, 1, n);
        return result;
    }
    
    private static int solve(int prev, int curr, int n) {
        
        if (curr > n)
            return (int) (1e9);
        
        if (curr == n)
            return 0;
        
        if (dp[prev][curr] != -1)
            return dp[prev][curr];
        
        int ff = (prev == 0) ? ((int) (1e9)) : (1 + solve(prev, curr + prev, n));
        int ss = 2 + solve(curr, 2 * curr, n);
        
        return dp[prev][curr] = Math.min(ff, ss);
    }
}