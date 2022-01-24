class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        
        int m = dungeon.length, n = dungeon[0].length;
        
        int dp[][] = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++)
            Arrays.fill(dp[i], (int) (1e9));
        dp[m - 1][n] = 0;
        dp[m][n - 1] = 0;
        
        for (int i = (m - 1); i >= 0; i--) {
            for (int j = (n - 1); j >= 0; j--) {
                dp[i][j] = Math.max(Math.min(dp[i][j + 1], dp[i + 1][j]) - dungeon[i][j], 0);
            }
        }
        
        return dp[0][0] + 1;
    }
}