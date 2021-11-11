class Solution {
    public int minStartValue(int[] nums) {
        
        int n = nums.length;
        int l = 1, r = (int) (1e4 + 10);
        while (r - l > 1) {
            int mid = l + ((r - l) / 2);
            if (_check(nums, mid))
                r = mid;
            else
                l = mid;
        }
        
        int result = _check(nums, l) ? l : r;
        return result;
    }
    
    private static boolean _check(int[] nums, int mid) {
        int sum = mid;
        for (int num: nums) {
            sum += num;
            if (sum < 1)
                return false;
        }
        
        return true;
    }
}s