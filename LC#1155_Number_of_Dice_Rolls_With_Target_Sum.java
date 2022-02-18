class Solution {
    
    private static final int mod = (int) (1e9 + 7);
    private static int[][] dp;
    public int numRollsToTarget(int n, int k, int target) {
        
        dp = new int[n + 1][1000];
        for (int i = 0; i <= n; i++)
            Arrays.fill(dp[i], -1);
        long result = solve(0, n, 0, target, k);
        return (int) result;
    }
    
    private static int solve(int i, int n, int sum, int target, int k) {
        
        if (i == n)
            return ((sum == target) ? 1 : 0);
        
        if (dp[i][sum] != -1)
            return dp[i][sum];
        
        int ans = 0;
        for (int num = 1; num <= k; num++)
            ans = (ans + solve(i + 1, n, sum + num, target, k)) % mod;
        
        return dp[i][sum] = ans;
    }
}