class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        int n = nums.length;
        int i = 0;
        while (i < n) {
            if (nums[i] != nums[nums[i] - 1]) swap(nums, i, nums[i] - 1);
            else i++;
        }
        
        List<Integer> ans = new ArrayList<>();
        for (i = 0; i < n; i++) 
            if (nums[i] != (i + 1)) ans.add(nums[i]);
        return ans;
    }
    
    private static void swap (int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}