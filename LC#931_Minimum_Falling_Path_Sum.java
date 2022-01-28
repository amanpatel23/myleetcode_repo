class Solution {
    
    private static final int inf = (int) (1e9);
    public int minFallingPathSum(int[][] matrix) {
        
        int n = matrix.length;
        int[][] dp = new int[n + 1][n + 2];
        Arrays.fill(dp[0], 0);
        for (int i = 0; i <= n; i++) {
            dp[i][0] = inf;
            dp[i][n + 1] = inf;
        }
        
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                int min = Math.min(dp[i - 1][j], 
                                   Math.min(dp[i - 1][j - 1], dp[i - 1][j + 1]));
                dp[i][j] = min + matrix[i - 1][j - 1];
            }
        }
        
        int result = inf;
        for (int j = 1; j <= n; j++)
            result = Math.min(result, dp[n][j]);
        
        return result;
    }
}