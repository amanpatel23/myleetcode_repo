class Solution {
    
    private static int[][] dp;
    public int countVowelStrings(int n) {
        dp = new int[n][5];
        for (int[] r : dp) Arrays.fill(r, -1);
        return solve(0, 0, n);
    }
    
    private static int solve(int curr, int i, int n) {
        if (i == n) return 1;
        if (dp[i][curr] != -1) return dp[i][curr];
        int ans = 0;
        for (int j = curr; j < 5; j++)
            ans += solve(j, i + 1, n);
        return dp[i][curr] = ans;
    }
}