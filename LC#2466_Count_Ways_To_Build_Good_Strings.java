class Solution {
    private static final int mod1 = (int) (1e9 + 7);
    private static int[] dp;
    public int countGoodStrings(int low, int high, int zero, int one) {

        dp = new int[high + 5];
        Arrays.fill(dp, -1);
        return total(0, low, high, zero, one);
    }
    
    private static int total(int len, int low, int high, int zero, int one) {
        if (len > high) return 0;
        
        if (dp[len] != -1) return dp[len];
        int ans = (len >= low) ? 1 : 0;
        ans = (ans + total(len + zero, low, high, zero, one)) % mod1;
        ans = (ans + total(len + one, low, high, zero, one)) % mod1;
        return dp[len] = ans;
    }
}