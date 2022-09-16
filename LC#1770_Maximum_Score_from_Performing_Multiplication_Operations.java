class Solution {
    
    private static int[][] dp;
    public int maximumScore(int[] arr1, int[] arr2) {
        
        int n = arr1.length, m = arr2.length;
        dp = new int[m][m];
        for (int[] r : dp) Arrays.fill(r, (int) (2e9));
        return solve(0, 0, n, m, arr1, arr2);
    }
    
    private static int solve(int ff, int bb, int n, int m, int[] arr1, int[] arr2) {
        
        if (ff + bb >= m) return 0;
        if (dp[ff][bb] != (int) (2e9)) return dp[ff][bb];
        int ans = (arr1[ff] * arr2[ff + bb]) + solve(ff + 1, bb, n, m, arr1, arr2);
        ans = Math.max(ans, (arr1[n - bb - 1] * arr2[ff + bb]) + 
                      solve(ff, bb + 1, n, m, arr1, arr2));
        return dp[ff][bb] = ans;
    }
}