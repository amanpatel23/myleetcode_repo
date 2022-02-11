class Solution {
    
    private static int n;
    public int minimumTime(String s) {
        
        n = s.length();
        int[] dp1 = new int[n + 1];
        int[] dp2 = new int[n + 1];
        
        util(s, dp1);
        String s_reversed = new StringBuilder(s).reverse().toString();
        util(s_reversed, dp2);
        
        int result = (int) (2e9);
        for (int i = 0; i <= n; i++) {
            result = Math.min(result, dp1[i] + dp2[n - i]);
        }
        
        return result;
    }
    
    private static void util(String s, int[] dp) {
        for (int i = 1; i <= n; i++) {
            if (s.charAt(i - 1) == '0') {
                dp[i] = dp[i - 1];
                continue;
            }
            dp[i] = Math.min(i, dp[i - 1] + 2);
        }
    }
}