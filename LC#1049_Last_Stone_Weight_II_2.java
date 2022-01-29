class Solution {
    public int lastStoneWeightII(int[] stones) {
        
        int n = stones.length;
        int sum = Arrays.stream(stones).sum();
        int target = sum / 2;
        
        int[][] dp = new int[n + 5][target + 5];
        Arrays.fill(dp[0], 0);
        dp[0][0] = 1;
        
        int can_make = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= target; j++) {
                dp[i][j] = (j < stones[i - 1]) ? 
                            dp[i - 1][j] :
                            (dp[i - 1][j] | dp[i - 1][j - stones[i - 1]]);
                if (dp[i][j] == 1)
                    can_make = j;
            }
        }
        
        return (sum - (2 * can_make));
    }
}