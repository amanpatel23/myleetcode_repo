class Solution {
    
    private static int[] dp;
    public int combinationSum4(int[] nums, int target) {
        
        dp = new int[target + 5];
        Arrays.fill(dp, -1);
        int result = solve(nums, target);
        return result;
    }
    
    private static int solve(int[] nums, int target) {
        
        if (target < 0)
            return 0;
        if (target == 0)
            return 1;
        
        if (dp[target] != -1)
            return dp[target];
        
        int ans = 0;
        for (int num : nums)
            ans += solve(nums, target - num);
        
        return dp[target] = ans;
    }
}