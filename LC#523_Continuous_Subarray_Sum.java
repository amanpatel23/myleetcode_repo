class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        int n = nums.length;
        int[] prefixSum = new int[n + 1];
        for (int i = 1; i <= n; i++) 
            prefixSum[i] = prefixSum[i - 1] + nums[i - 1];
        for (int i = 1; i <= n; i++) {
            int div = (nums[i - 1] + k - 1) / k;
            long xx = (long) k * div;
            while (xx <= prefixSum[i]) {
                if (bs(prefixSum, i, (int) xx)) return true;
                xx += k;
            }
        }
        return false;
    }
    
    private boolean bs(int[] prefixSum, int ii, int xx) {
        int l = 0, r = ii;
        while (r - l > 1) {
            int mid = l + ((r - l) / 2);
            int sum = prefixSum[ii] - prefixSum[mid];
            if (sum > xx) l = mid;
            else r = mid;
        }
        if (ii - r >= 2 && prefixSum[ii] - prefixSum[r] == xx) return true;
        if (ii - l >= 2 && prefixSum[ii] - prefixSum[l] == xx) return true;
        return false;
    }
}