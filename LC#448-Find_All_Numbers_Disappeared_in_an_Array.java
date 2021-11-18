class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] == -1)
                continue;
            
            // calling recursive function
            util(nums, nums[i] - 1);
        }
        
        // traversing once again to store missing numbers
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (nums[i] != -1)
                result.add(i + 1);
        }
        
        return result;
    }
    
    private static void util(int[] nums, int idx) {
        
        if (nums[idx] == -1)
            return;
        
        int _idx = nums[idx] - 1;
        nums[idx] = -1;
        util(nums, _idx);
    }
}