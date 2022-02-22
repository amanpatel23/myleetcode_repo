class Solution {
    
    private static final int mod = (int) (1e9 + 7);
    private static int[][][] dp = new int[5001][7][16];
    private static int[] rollMax;
    public int dieSimulator(int n, int[] _rollMax) {
        
        rollMax = _rollMax;
        for (int i = 0; i <= 5000; i++) {
            for (int j = 0; j <= 6; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }
        
        int result = 0;
        for (int x = 1; x <= 6; x++) {
            result = (result + solve(n - 1, x, 1)) % mod;
        }
        
        return result;
    }
    
    private static int solve(int i, int prev, int cnt) {
        
        if (cnt > rollMax[prev - 1])
            return 0;
        
        if (i == 0)
            return 1;
        
        if (dp[i][prev][cnt] != -1)
            return dp[i][prev][cnt];
        
        int ans = 0;
        for (int x = 1; x <= 6; x++) {
            int cnt_new = (x == prev) ? (cnt + 1) : 1;
            ans = (ans + solve(i - 1, x, cnt_new)) % mod;
        }
        
        return dp[i][prev][cnt] = ans;
    }
}