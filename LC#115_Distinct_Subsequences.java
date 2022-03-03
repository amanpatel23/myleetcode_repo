class Solution {
    
    private static String s, t;
    private static int n1, n2;
    private static final int[][] dp = new int[1005][1005];
    public int numDistinct(String _s, String _t) {
        
        s = _s;
        t = _t;
        n1 = s.length();
        n2 = t.length();
        
        for (int[] row : dp)
            Arrays.fill(row, -1);
        
        return solve(0, 0);
    }
    
    private static int solve(int i, int j) {
        
        if (j == n2)
            return 1;
        if (i == n1)
            return 0;
        
        if (dp[i][j] != -1)
            return dp[i][j];
        
        int ans = solve(i + 1, j);
        if (s.charAt(i) == t.charAt(j))
            ans += solve(i + 1, j + 1);
        
        return (dp[i][j] = ans);
    }
}