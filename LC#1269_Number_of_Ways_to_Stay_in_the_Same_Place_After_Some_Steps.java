class Solution {
    
    private static final int mod = (int) (1e9 + 7);
    public int numWays(int _k, int _n) {
        
        int n = Math.min(_n, _k);
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        
        int k = _k - 1;
        while (k-- > 0) {
            int[] temp = dp.clone();
            for (int i = 0; i < n; i++) {
                dp[i] = ((temp[i] + (i == 0 ? 0 : temp[i - 1])) % mod + 
                        (i == n - 1 ? 0 : temp[i + 1])) % mod;
            }
        }
        
        return dp[0];
    }
}