class Solution {
    
    private final List<Integer> primes = new ArrayList<>(List.of(2, 3, 5, 7));
    private final int mod = (int) (1e9 + 7);
    private int[][] dp;
    public int beautifulPartitions(String s, int k, int minLen) {
        
        boolean flag = primes.contains(s.charAt(0) - '0') && 
            !primes.contains(s.charAt(s.length() - 1) - '0');
        if (!flag) return 0;
        
        dp = new int[s.length()][k];
        for (int[] r : dp) Arrays.fill(r, -1);
        
        return totalWays(minLen - 1, k - 1, s, minLen);
        
    }
    
    private int totalWays(int i, int k, String s, int minLen) {
        if (k == 0) return (i < s.length() ? 1 : 0);
        if (i >= s.length()) return 0;
        if (dp[i][k] != -1) return dp[i][k];
        boolean flag = !primes.contains(s.charAt(i) - '0') && i < s.length() - 1 && 
            primes.contains(s.charAt(i + 1) - '0');
        long ans = totalWays(i + 1, k, s, minLen);
        if (flag) ans = (ans + totalWays(i + minLen, k - 1, s, minLen)) % mod;
        
        return dp[i][k] = (int) ans;
    }
}