class Solution {
    public long mostPoints(int[][] q) {

        int n = q.length;
        long[] dp = new long[n + 5];
        Arrays.fill(dp, -1L);
        
        long result = util(q, n, dp, 0);
        return result;
    }

    private static long util(int[][] q, int n, long[] dp, int i) {

        if (i >= n)
            return 0;

        if (dp[i] != -1L)
            return dp[i];
        
        return dp[i] = Math.max(q[i][0] + util(q, n, dp, i + q[i][1] + 1),
                util(q, n, dp, i + 1));   
    }
}