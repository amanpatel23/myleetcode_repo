class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        
        int[][] dp = new int[m + 1][n + 1];
        for (String s : strs) {
            int zeroes = (int) s.chars().filter(c -> (c == '0')).count();
            int ones = s.length() - zeroes;
            for (int i = m; i >= zeroes; i--) {
                for (int j = n; j >= ones; j--) {
                    dp[i][j] = Math.max(1 + dp[i - zeroes][j - ones], dp[i][j]);
                }
            }
        }
        
        return dp[m][n];
    }
}