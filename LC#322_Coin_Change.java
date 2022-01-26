class Solution {
    public int coinChange(int[] coins, int amount) {
        
        int m = coins.length;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, (int) (1e9));
        dp[0] = 0;
        
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= amount; j++) {
                if (j >= coins[i - 1]) 
                    dp[j] = Math.min(dp[j], 1 + dp[j - coins[i - 1]]);
            }
        }
        
        if (dp[amount] >= (int) (1e9))
            return -1;
        return dp[amount];
    }
}