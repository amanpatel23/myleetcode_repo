class Solution {
    public int maxOperations(int[] nums, int k) {
        
        int n = nums.length;
        Arrays.sort(nums);
        int i = 0, j = n - 1;
        int ans = 0;
        while (j > i) {
            int sum = nums[i] + nums[j];
            if (sum == k) {
                ans++;
                i++;
                j--;
            }else if (sum < k) i++;
            else j--;
        }
        
        return ans;
    }
}