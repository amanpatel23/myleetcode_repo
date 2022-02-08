class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        
        int n = nums.length;
        int sum = Arrays.stream(nums).sum();
        if (!(Math.abs(target) <= sum && ((sum + target) & 1) == 0))
            return 0;
        
        int s1 = (sum + target) / 2;
        int[] dp = new int[s1 + 5], temp = new int[s1 + 5];
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= s1; j++) {
                temp[j] = dp[j];
                dp[j] = ((nums[i - 1] <= j) ? temp[j - nums[i - 1]] : 0) + temp[j];
            }
        }
        
        return dp[s1];
    }
}