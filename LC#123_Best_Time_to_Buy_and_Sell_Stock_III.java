class Solution {
    
    private static int n;
    private static final int[][] dp = new int[4][(int) (1e5) + 5];
    public int maxProfit(int[] prices) {
        
        n = prices.length;
        for (int[] row : dp)
            Arrays.fill(row, -1);
        
        return solve(prices, 0, 0);
    }
    
    private static int solve(int[] prices, int i, int step) {
        
        if (i == n || step >= 4)
            return 0;
        
        if (dp[step][i] != -1)
            return dp[step][i];
        
        if ((step & 1) == 0)
            return dp[step][i] = Math.max(-prices[i] + solve(prices, i + 1, step + 1), 
                            solve(prices, i + 1, step));
        return dp[step][i] = Math.max(prices[i] + solve(prices, i + 1, step + 1), 
                       solve(prices, i + 1, step));
    }
}