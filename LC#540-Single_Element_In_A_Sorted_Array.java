class Solution {
    public int singleNonDuplicate(int[] nums) {
        
        int n = nums.length;
        if (n == 1)
            return nums[0];
        
        int l = 0, r = n - 1;
        while (r - l > 1) {
            int x = (l + r) / 2;
            int ans = _check(nums, n, x);
            if (ans == -1)
                l = x;
            else if(ans == -2)
                r = x;
            else
                return ans;
        }
        
        int ans1 = _check(nums, n, l);
        if (ans1 >= 0)
            return ans1;
        return _check(nums, n, r);
    }
    
    private static int _check(int[] nums, int n, int x) {
        
        // -1 -> left, -2 -> right
        if (x == 0) {
            if (nums[x] != nums[x + 1])
                return nums[x];
            return -1;
        }

        if (x == n - 1) {
            if (nums[x] != nums[x - 1])
                return nums[x];
            return -2;
        }

        if (nums[x] == nums[x - 1]) {
            if ((x & 1) == 1)
                return -1;
            return -2;
        }

        if (nums[x] == nums[x + 1]) {
            if ((x & 1) == 1)
                return -2;
            else
                return -1;

        }

        return nums[x];
    }
}