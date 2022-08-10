class Solution {
    public long minimumReplacement(int[] nums) {
        int n = nums.length;
        long prev = nums[n - 1];
        long ans = 0;
        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] <= prev) {
                prev = nums[i];
                continue;
            }
            long div = ceilDiv(nums[i], prev);
            ans += (div - 1);
            prev = nums[i] / div;
        }
        return ans;
    }
    
    private static long ceilDiv(long a, long b) {
        return ((a + b - 1) / b);
    }
}