class Solution {
    public int countSubstrings(String s) {
        
        int n = s.length();
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) dp[i][i] = 1;
        for (int i = 0; i + 1 < n; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) dp[i][i + 1] = 1;
        }
        
        for (int g = 2; g < n; g++) {
            for (int i = 0; i + g < n; i++) {
                if (s.charAt(i) == s.charAt(i + g) && dp[i + 1][i + g - 1] == 1)
                    dp[i][i + g] = 1;
            }
        }
        
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (dp[i][j] == 1) ans++;
            }
        }
        return ans;
    }
}