class Solution {
    public int subarrayGCD(int[] nums, int k) {

        int n = nums.length;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int gcd = nums[i];
            for (int j = i; j < n; j++) {
                gcd = (int) gcd(gcd, nums[j]);
                if (gcd < k) break;
                if (gcd == k) ans++;
            }
        }
        return ans;
    }
    
    private long gcd(long a, long b) {
        return (b == 0 ? a : gcd(b, a % b));
    }
}