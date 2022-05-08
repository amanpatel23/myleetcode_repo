class Solution {
    
    private static final int mod = (int) (1e9 + 7);
    private static int[] atMax;
    private static long[][] dp;
    public int countTexts(String s) {
        
        atMax = new int[10];
        Arrays.fill(atMax, 3);
        atMax[7] = 4; atMax[9] = 4;
        
        int n = s.length();
        dp = new long[n][5];
        for (long[] r : dp) Arrays.fill(r, -1);
        
        return (int) solve(0, 1, s, n);
    }
    
    private static long solve(int i, int freq, String s, int n) {
        if (atMax[s.charAt(i) - '0'] < freq) return 0;
        if (i == (n - 1)) return 1;
        if (dp[i][freq] != -1) return dp[i][freq];
        long ans = solve(i + 1, 1, s, n);
        if (s.charAt(i) == s.charAt(i + 1)) ans = (ans + solve(i + 1, freq + 1, s, n)) % mod;
        return dp[i][freq] = ans;
    }
}