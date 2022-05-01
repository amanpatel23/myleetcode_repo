class Solution {
    public int missingNumber(int[] nums) {
        
        int n = nums.length;
        int i = 0;
        while (i < n) {
            if (nums[i] == i || nums[i] == n) i++;
            else swap(nums[i], i, nums);
        }
        
        int ans = n;
        for (i = 0; i < n; i++) if (nums[i] != i) ans = i;
        return ans;
    }
    
    private static void swap(int a, int b, int[] nums) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}