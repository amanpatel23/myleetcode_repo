class Solution {
    
    private static int m, n;
    private static int[][][] dp;
    public boolean hasValidPath(char[][] grid) {
        
        if (grid[0][0] == ')') return false;
        
        m = grid.length; n = grid[0].length;
        dp = new int[m][n][m + n + 5];
        for (int[][] r1 : dp) {
            for (int[] r2 : r1) {
                Arrays.fill(r2, -1);
            }
        }
        
        return solve(0, 0, 1, grid);
    }
    
    private static boolean solve(int i, int j, int openings, char[][] grid) {
        if (openings < 0) return false;
        if (i == m - 1 && j == n - 1 && openings == 0) return true;
        if (dp[i][j][openings] != -1) return (dp[i][j][openings] == 1);
        boolean ans = false;
        // right
        if (j + 1 < n) ans = ans || solve(i, j + 1, openings + (grid[i][j + 1] == '(' ? 1 : -1), grid);
        // down
        if (i + 1 < m) ans = ans || solve(i + 1, j, openings + (grid[i + 1][j] == '(' ? 1 : -1), grid);
        
        dp[i][j][openings] = (ans ? 1 : 0);
        return ans;
    }
}