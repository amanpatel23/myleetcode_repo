class Solution {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        if (minK > maxK) return 0;
        int n = nums.length;
        int i = 0, j = 0;
        int[] latestOccu = new int[]{-1, -1};
        long ans = 0;
        while (j < n) {
            if (nums[j] > maxK || nums[j] < minK) {
                latestOccu[0] = -1; latestOccu[1] = -1;
                j++;
                i = j;
                continue;
            }
            if (nums[j] == minK) latestOccu[0] = j;
            if (nums[j] == maxK) latestOccu[1] = j;
            if (!(latestOccu[0] == -1 || latestOccu[1] == -1))
                ans += (Math.min(latestOccu[0], latestOccu[1]) - i + 1);
            j++;
        }
        return ans;
    }
}