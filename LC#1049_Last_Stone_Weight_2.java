class Solution {
    
    private static final int[][] dp = new int[35][3005];
    public int lastStoneWeightII(int[] stones) {
        
        for (int i = 0; i < 35; i++)
            Arrays.fill(dp[i], -1);
        
        int result = solve(stones, 0, 0, 0);
        return result;
    }
    
    private static int solve(int[] stones, int i, int sum1, int sum2) {
        
        if (i == stones.length)
            return (Math.abs(sum1 - sum2));
        
        int diff = Math.abs(sum1 - sum2);
        if (dp[i][diff] != -1)
            return dp[i][diff];
        
        return dp[i][diff] = Math.min(solve(stones, i + 1, sum1 + stones[i], sum2), 
                       solve(stones, i + 1, sum1, sum2 + stones[i]));
    }
}