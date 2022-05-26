class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        return helper(nums, k) - helper(nums, k - 1);
    }
    
    private static int helper(int[] nums, int k) {
        int idx = 0;
        int ans = 0;
        int no_of_odds = 0;
        for (int i = 0; i < nums.length; i++) {
            if ((nums[i] & 1) == 1)
                no_of_odds++;
            while (no_of_odds > k) {
                if ((nums[idx] & 1) == 1) 
                    no_of_odds--;
                idx++;
            }
            ans += (i - idx + 1);
        }
        return ans;
    }
}