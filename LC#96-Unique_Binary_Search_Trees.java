class Solution {
    public int numTrees(int n) {
        
        int[] dp = new int[n + 1];
        dp[0] = 1; dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            int ans = 0;
            for (int idx = 0; idx < i; idx++) {
                ans += (dp[idx] * dp[i - 1 - idx]);
            }
            dp[i] = ans;
        }
        
        return dp[n];
    }
}s