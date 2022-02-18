class Solution {
    
    private static final int mod = (int) (1e9 + 7);
    public int numRollsToTarget(int n, int k, int target) {
        
        int[] dp = new int[target + 1], temp = new int[target + 1];
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= target; j++) {
                temp[j] = dp[j];
                dp[j] = 0;
                for (int num = 1; num <= k; num++) {
                    if (num > j)
                        break;
                    dp[j] = (dp[j] + temp[j - num]) % mod;
                }
            }
        }
        
        return dp[target];
    }
}