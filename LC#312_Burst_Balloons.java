class Solution {
    public int maxCoins(int[] nums) {
        
        int n = nums.length;
        int[][] dp = new int[n][n];
        
        int d = 0;
        for (int cnt = 0; cnt < n; cnt++) {
            for (int i = 0; i < n; i++) {
                int j = i + d;
                if (j >= n)
                    break;
                for (int k = i; k <= j; k++) {
                    dp[i][j] = Math.max(dp[i][j], (k == i ? 0 : dp[i][k - 1]) + 
                                (k == j ? 0 : dp[k + 1][j]) + 
                                (nums[k] * (i == 0 ? 1 : nums[i - 1]) * 
                                 (j == n - 1 ? 1 : nums[j + 1])));
                }
            }
            d++;
        }
        
        return dp[0][n - 1];
    }
}