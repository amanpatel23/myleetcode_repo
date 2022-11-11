class Solution {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        int idx = 0;
        for (int i = 1; i < n; i++) {
            if (nums[i] != nums[i - 1]) {
                nums[idx++] = nums[i - 1];
            }
        }
        nums[idx] = nums[n - 1];
        return idx + 1;
    }
}