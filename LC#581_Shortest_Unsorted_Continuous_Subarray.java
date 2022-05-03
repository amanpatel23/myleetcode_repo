class Solution {
    public int findUnsortedSubarray(int[] nums) {
        
        int[] nums_copy = nums.clone();
        Arrays.sort(nums_copy);
        int l = (int) (1e5), r = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums_copy[i] == nums[i]) continue;
            l = Math.min(l, i);
            r = Math.max(r, i);
        }
        return (r == -1 ? 0 : (r - l + 1));
    }
}