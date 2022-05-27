class Solution {
    public int findLength(int[] nums1, int[] nums2) {
        int n1 = nums1.length, n2 = nums2.length;
        int[] dp = new int[n2 + 1];
        int ans = 0;
        for (int i = 1; i <= n1; i++) {
            int prev = 0;
            for (int j = 1; j <= n2; j++) {
                int temp = dp[j];
                dp[j] = 0;
                if (nums1[i - 1] == nums2[j - 1]) 
                    dp[j] = 1 + prev;
                prev = temp;
                ans = Math.max(ans, dp[j]);
            }
        }
        return ans;
    }
}