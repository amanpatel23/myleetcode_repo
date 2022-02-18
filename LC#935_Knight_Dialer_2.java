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
    public int knightDialer(int n) {
        
        int[] dp = new int[10], temp = new int[10];
        Arrays.fill(dp, 1);
        
        for (int j = 2; j <= n; j++) {
            for (int i = 0; i < 10; i++)
                temp[i] = dp[i];
            for (int i = 0; i < 10; i++) {
                dp[i] = 0;
                for (int x : arr[i])
                    dp[i] = (dp[i] + temp[x]) % mod;
            }
        }
        
        return Arrays.stream(dp).reduce(0, (a, b) -> ((a + b) % mod));
    }
}