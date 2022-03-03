class Solution {
    public int numDistinct(String s, String t) {
        
        int n1 = s.length(), n2 = t.length();
        int[][] dp = new int[n2 + 1][n1 + 1];
        Arrays.fill(dp[0], 1);
        for (int i = 1; i <= n2; i++) {
            for (int j = 1; j <= n1; j++) {
                if (j < i)
                    continue;
                dp[i][j] = ((s.charAt(j - 1) == t.charAt(i - 1)) ? dp[i - 1][j - 1] : 0) 
                            + dp[i][j - 1];
            }
        }
        
        return dp[n2][n1];
    }
}