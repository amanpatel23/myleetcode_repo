class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;
        int ans = (int) (1e9);
        for (int j = 1; j < n - 1; j++) {
            int i = 0, k = n - 1;
            while (i < j && k > j) {
                int curr = nums[i] + nums[j] + nums[k];
                if (Math.abs(target - curr) < Math.abs(target - ans))
                    ans = curr;
                if (curr <= target) i++;
                else k--;
            }
        }
        return ans;
    }
}