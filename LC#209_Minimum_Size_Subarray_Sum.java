class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int sum = 0;
        int idx = 0;
        int ans = nums.length + 1;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            boolean flag = false;
            while (sum >= target) {
                sum -= nums[idx++];
                flag = true;
            }
            if (flag) ans = Math.min(i - idx + 2, ans);
        }
        return (ans > nums.length ? 0 : ans);
    }
}