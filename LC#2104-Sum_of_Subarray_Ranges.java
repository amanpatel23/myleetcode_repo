class Solution {
        
    private static final int iMax = (int) (1e9), iMin = (int) (-1e9);
    public long subArrayRanges(int[] nums) {

        int n = nums.length;
        long result = 0;
        for (int i = 0; i < n; i++) {
            int _max = iMin, _min = iMax;
            for (int j = i; j < n; j++) {
                _max = Math.max(_max, nums[j]);
                _min = Math.min(_min, nums[j]);
                result += (_max - _min);
            }
        }

        return result;
    }
}