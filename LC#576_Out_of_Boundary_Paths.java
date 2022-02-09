class Solution {
    
    private static int mod = (int) (1e9 + 7);
    private static int[] dr = new int[]{-1, +1, 0, 0};
    private static int[] dc = new int[]{0, 0, +1, -1};
    private static int m, n, sr, sc;
    private static long[][][] dp;
    public int findPaths(int _m, int _n, int x, int _sr, int _sc) {
        
        m = _m;
        n = _n;
        sr = _sr;
        sc = _sc;
        dp = new long[m][n][x + 1];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }
        
        long result = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int cnt = 0;
                for (int k = 0; k < 4; k++) {
                    int temp_r = i + dr[k], temp_c = j + dc[k];
                    if (temp_r < 0 || temp_r >= m || temp_c < 0 || temp_c >= n)
                        cnt++;
                }
                if (cnt > 0)
                    result = (result + (cnt * solve(i, j, x))) % mod;
            }
        }
        
        return (int) result;
    }
    
    private static long solve(int i, int j, int x) {
        
        if (i < 0 || i >= m || j < 0 || j >= n || x <= 0)
            return 0;
        
        if (dp[i][j][x] != -1)
            return dp[i][j][x];
        
        long ans = (i == sr && j == sc) ? 1 : 0;
        for (int k = 0; k < 4; k++)
            ans = (ans + solve(i + dr[k], j + dc[k], x - 1)) % mod;
        return (dp[i][j][x] = ans);
    }
}