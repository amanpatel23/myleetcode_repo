class Solution {

    private static int mod = (int) (1e9 + 7);
    private static int[] dr = new int[]{-1, +1, 0, 0};
    private static int[] dc = new int[]{0, 0, +1, -1};
    public int findPaths(int m, int n, int N, int sr, int sc) {
        
        int[][] dp = new int[m][n];
        dp[sr][sc] = 1;
        int result = 0;
        for (int x = 1; x <= N; x++) {
            int[][] temp = new int[m][n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (i == 0) result = (result + dp[i][j]) % mod;
                    if (j == 0) result = (result + dp[i][j]) % mod;
                    if (i == m - 1) result = (result + dp[i][j]) % mod;
                    if (j == n - 1) result = (result + dp[i][j]) % mod;
                    
                    for (int k = 0; k < 4; k++) {
                        int r_new = i + dr[k];
                        int c_new = j + dc[k];
                        if (r_new < 0 || r_new >= m || c_new < 0 || c_new >= n)
                            continue;
                        temp[i][j] = (temp[i][j] + dp[r_new][c_new]) % mod;
                    }
                }
            }
            dp = temp;
        }
        
        return result;
    }
}