class Solution {
    
    private static int n;
    private static int[][] dp;
    public int maximumANDSum(int[] nums, int m) {
        
        n = nums.length;
        List<Integer> mask_list = new ArrayList<>();
        int upper = (1 << (2 * m));
        for (int i = 0; i < upper; i++) {
            int cnt = 0;
            for (int j = 0; j <= 20; j++) {
                if (((i >> j) & 1) == 1)
                    cnt++;
            }
            if (cnt == n)
                mask_list.add(i);
        }
        
        dp = new int[n + 5][upper + 5];
        for (int i = 0; i <= n; i++)
            Arrays.fill(dp[i], -1);
        
        int result = (int) (-1e9);
        for (int mask : mask_list) {
            result = Math.max(result, solve(nums, 0, mask));
        }
        
        return result;
    }
    
    private static int solve(int[] nums, int i, int mask) {
        
        if (i >= n)
            return 0;
        
        if (dp[i][mask] != -1)
            return dp[i][mask];
        
        int ans = (int) (-1e9);
        for (int j = 0; j <= 20; j++) {
            if (((mask >> j) & 1) == 1) {
                int pos = (j / 2) + 1;
                int temp = (nums[i] & pos);
                ans = Math.max(ans, temp + solve(nums, i + 1, mask ^ (1 << j)));
            }
        }
        
        return dp[i][mask] = ans;
    }
}