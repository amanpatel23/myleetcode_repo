class Solution {
    public int maximumTop(int[] nums, int k) {
        
        if (k == 0)
            return nums[0];
        
        int n = nums.length;
        if (n == 1) {
            return ((k & 1) == 1) ? -1 : nums[0];
        }
        
        int[] prefix_max = new int[n];
        prefix_max[0] = nums[0];
        for (int i = 1; i < n; i++)
            prefix_max[i] = Math.max(nums[i], prefix_max[i - 1]);
        
        if (k > n)
            return prefix_max[n - 1];
        if (k == n)
            return prefix_max[k - 2];
        if (k == 1)
            return nums[1];
        return Math.max(prefix_max[k - 2], nums[k]);
    }
}