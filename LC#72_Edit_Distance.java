class Solution {
    
    private static String w1, w2;
    private static int n1, n2;
    private static final int[][] dp = new int[505][505];
    public int minDistance(String word1, String word2) {
        
        w1 = word1;
        w2 = word2;
        n1 = word1.length();
        n2 = word2.length();
        
        for (int i = 0; i <= 500; i++)
            Arrays.fill(dp[i], -1);
        
        return solve(0, 0);
    }
    
    private static int solve(int i, int j) {
        
        if (i == n1 && j == n2)
            return 0;
        if (i == n1)
            return (n2 - j);
        if (j == n2)
            return (n1 - i);
        
        if (dp[i][j] != -1)
            return dp[i][j];
        
        if (w1.charAt(i) == w2.charAt(j))
            return dp[i][j] = solve(i + 1, j + 1);
        int ans = (int) (1e9);
        ans = 1 + Math.min(solve(i, j + 1), 
                           Math.min(solve(i + 1, j), solve(i + 1, j + 1)));
        return (dp[i][j] = ans);
    }
}