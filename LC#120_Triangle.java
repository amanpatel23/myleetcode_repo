class Solution {
    
    private static final int iMax = (int) (1e9);
    public int minimumTotal(List<List<Integer>> triangle) {
        
        int m = triangle.size();
        int n = triangle.get(m - 1).size();
        
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                dp[i][j] = iMax;
            }
        }
        dp[0][0] = 0;
        
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i][j] = triangle.get(i - 1).get(j - 1) + 
                            Math.min(dp[i - 1][j], dp[i - 1][j - 1]);       
            }
        }
        
        return Arrays.stream(dp[m]).min().getAsInt();
    }
}