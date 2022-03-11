class Solution {
    
    private static int n1, n2;
    private static String s1, s2;
    private static final int[][] dp = new int[1001][1001];
    public int minimumDeleteSum(String _s1, String _s2) {
        
        s1 = _s1;
        s2 = _s2;
        n1 = s1.length();
        n2 = s2.length();
        
        for (int[] r : dp)
            Arrays.fill(r, -1);
        
        return solve(0, 0);
    }
    
    private static int solve(int i, int j) {
        
        if (i == n1) {
            int sum = 0;
            while (j < n2) {
                sum += s2.charAt(j);
                j++;
            }
            return sum;
        }
        
        if (j == n2) {
            int sum = 0;
            while (i < n1) {
                sum += s1.charAt(i);
                i++;
            }
            return sum;
        }
        
        if (dp[i][j] != -1)
            return dp[i][j];
        
        if (s1.charAt(i) == s2.charAt(j))
            return dp[i][j] = solve(i + 1, j + 1);
        
        return dp[i][j] = Math.min(s1.charAt(i) + solve(i + 1, j), 
                                   s2.charAt(j) + solve(i, j + 1));
    }
}