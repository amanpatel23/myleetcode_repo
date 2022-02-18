class Solution {
    
    private static final int[][] arr = new int[][]{{4, 6}, 
                                                   {6, 8}, 
                                                   {7, 9}, 
                                                   {4, 8}, 
                                                   {0, 3, 9}, 
                                                   {}, 
                                                   {0, 1, 7}, 
                                                   {2, 6}, 
                                                   {1, 3}, 
                                                   {2, 4}};
    private static final int mod = (int) (1e9 + 7);
    private static long[][] dp = new long[10][5005];
    public int knightDialer(int n) {
        
        for (int i = 0; i < 10; i++)
            Arrays.fill(dp[i], -1);
        
        long result = 0;
        for (int i = 0; i < 10; i++)
            result = (result + solve(1, n, i)) % mod;
        
        return (int) result;
    }
    
    private static long solve(int i, int steps, int curr) {
        
        if (i == steps)
            return 1;
        
        if (dp[curr][i] != -1)
            return dp[curr][i];
        
        long ans = 0;
        for (int x : arr[curr])
            ans = (ans + solve(i + 1, steps, x)) % mod;
        
        return dp[curr][i] = ans;
    }
}