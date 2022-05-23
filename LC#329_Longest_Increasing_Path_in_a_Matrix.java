class Solution {
    private static final int[][] dir = new int[][]{{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
    private static int m, n;
    private static int[][] dp;
    public int longestIncreasingPath(int[][] matrix) {
        m = matrix.length; n = matrix[0].length;
        dp = new int[m][n];
        for (int[] r : dp) Arrays.fill(r, -1);
        int ans = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                ans = Math.max(ans, solve(i, j, matrix));
            }
        }
        
        return ans;
    }
    
    private static int solve(int i, int j, int[][] matrix) {
        
        if (dp[i][j] != -1) return dp[i][j];
        int ans = 1;
        for (int k = 0; k < 4; k++) {
            int r = i + dir[k][0], c = j + dir[k][1];
            if (r < 0 || r >= m || c < 0 || c >= n || matrix[r][c] <= matrix[i][j]) 
                continue;
            ans = Math.max(ans, 1 + solve(r, c, matrix));
        }
        
        return dp[i][j] = ans;
    }
}