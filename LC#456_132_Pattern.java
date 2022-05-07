class Solution {
    
    private static final int iMax = (int) (1e9 + 100);
    public boolean find132pattern(int[] nums) {
        
        int n = nums.length;
        int[] prefix_min = new int[n];
        int min = iMax;
        for (int i = 0; i < n; i++) {
            min = Math.min(min, nums[i]);
            prefix_min[i] = min;
        }
        TreeSet<Integer> set = new TreeSet<>();
        for (int i = (n - 1); i >= 0; i--) {
            Integer lower = set.lower(nums[i]);
            if (lower != null && prefix_min[i] < lower) return true;
            set.add(nums[i]);
        }
        return false;
    }
}