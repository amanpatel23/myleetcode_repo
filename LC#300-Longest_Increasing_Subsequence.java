class Solution {
    public int lengthOfLIS(int[] nums) {
        
        int n = nums.length;
        int[] LIS = new int[n];
        Arrays.fill(LIS, 1);
        int global = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i] && LIS[j] >= LIS[i])
                    LIS[i] = LIS[j] + 1;
            }
            global = Math.max(global, LIS[i]);
        }
        
        return global;
    }
}