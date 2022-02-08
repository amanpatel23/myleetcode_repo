class Solution {
    
    private static int[][] dp = new int[25][10000];
    private static int n;
    public int findTargetSumWays(int[] nums, int target) {
        
        n = nums.length;
        for (int i = 0; i <= 20; i++)
            Arrays.fill(dp[i], -1);
        
        return solve(nums, 0, target);
    }
    
    private static int solve(int[] nums, int i, int target) {
        
        if (i >= n)
            return ((target == 0) ? 1 : 0);
        
        if (dp[i][target + 1000] != -1)
            return dp[i][target + 1000];
        
        return dp[i][target + 1000] = solve(nums, i + 1, target + nums[i]) +
                                    solve(nums, i + 1, target - nums[i]);
    }
}