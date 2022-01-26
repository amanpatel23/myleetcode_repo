class Solution {
    
    private static int len;
    private static int[][] arr;
    private static int[][][] dp;
    public int findMaxForm(String[] strs, int m, int n) {
        
        len = strs.length;
        
        arr = new int[len][2];
        for (int i = 0; i < len; i++) {
            for (char x : strs[i].toCharArray()) {
                if (x == '0')
                    arr[i][0]++;
                else
                    arr[i][1]++;
            }
        }
        
        dp = new int[len][m + 1][n + 1];
        for (int i = 0; i < len; i++) {
            for (int j = 0; j <= m; j++) {
                for (int k = 0; k <= n; k++) {
                    dp[i][j][k] = -1;
                }
            }
        }
        
        int result = solve(0, m, n);
        return result;
    }
    
    private static int solve(int i, int z, int o) {
        
        if (i >= len)
            return 0;
        
        if (dp[i][z][o] != -1)
            return dp[i][z][o];
        
        int skip = solve(i + 1, z, o);
        int consider = 0;
        if (arr[i][0] <= z && arr[i][1] <= o)
            consider = 1 + solve(i + 1, z - arr[i][0], o - arr[i][1]);
        
        return dp[i][z][o] = Math.max(skip, consider);
    }
}