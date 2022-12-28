class Solution {
    
    private final int mod = (int) (1e9 + 7);
    private long pow(long base, long exponent) {
        if (exponent == 0) {
            return 1;
        }
        
        if ((exponent & 1) == 1) {
            return (base * pow(base, exponent - 1)) % mod;
        }
        
        long result = pow(base, exponent / 2);
        return (result * result) % mod;
    }
    
    public int countPartitions(int[] nums, int k) {
        
        long sum = 0;
        for (int num : nums) sum += num;
        if (sum < 2 * k) return 0;
        
        int n = nums.length;
        long ans = pow(2, n);
        
        int[][] dp = new int[n + 1][k];
        dp[0][0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < k; j++) {
                int num = nums[i - 1];
                dp[i][j] = dp[i - 1][j];
                if (num <= j) {
                    dp[i][j] = (dp[i][j] + dp[i - 1][j - num]) % mod;
                }
            }
        }
        
        for (int j = 0; j < k; j++) {
            long temp = (2 * dp[n][j]) % mod;
            ans = (ans - temp + mod) % mod;
        }
        
        return (int) ans;
    }
}