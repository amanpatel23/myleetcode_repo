class Solution {
    
    private static final int iMin = (int) (-1e9);
    public int maxSubArray(int[] nums) {
        
        int n = nums.length;
        int[] prefixSum = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            prefixSum[i] = prefixSum[i - 1] + nums[i - 1];
        }
        
        int _min = 0;
        int result = iMin;
        for (int i = 1; i <= n; i++) {
            int curr = prefixSum[i] - _min;
            result = Math.max(result, curr);
            _min = Math.min(_min, prefixSum[i]);
        }
        
        return result;
    }
}