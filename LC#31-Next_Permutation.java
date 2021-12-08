class Solution {
    public void nextPermutation(int[] nums) {
        
        int n = nums.length;
        int idx1 = -1, idx2 = n - 1;
        for (int i = (n - 2); i >= 0; i--) {
            if (nums[i] < nums[idx2]) {
                idx1 = i;
                break;
            }
            idx2 = i;
        }
        
        if (idx1 != -1) {
            for (int i = (n - 1); i > idx1; i--) {
                if (nums[i] > nums[idx1] && nums[i] < nums[idx2])
                    idx2 = i;
            }
            
            swap(nums, idx1, idx2);
        }
        
        Arrays.sort(nums, idx1 + 1, n);
    }
    
    private static void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}