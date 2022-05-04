class Solution {
    public int[] findErrorNums(int[] nums) {
        int n = nums.length;
        int i = 0;
        while (i < n) {
            if (nums[i] != nums[nums[i] - 1]) swap(nums, i, nums[i] - 1);
            else i++;
        }
        int[] ans = new int[]{-1, -1};
        for (i = 0; i < n; i++) {
            if (nums[i] == i + 1) continue;
            ans[0] = nums[i];
            ans[1] = i + 1;
            break;
        }
        return ans;
    }
    
    private static void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}