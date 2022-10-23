class Solution {
    public long makeSimilar(int[] nums, int[] target) {

        int n = nums.length;
        Arrays.sort(nums);
        Arrays.sort(target);
        long ans = 0;
        int i = 0, j = 0;
        while (i < n) {
            if ((nums[i] & 1) == 1) {
                i++;
                continue;
            }
            if ((target[j] & 1) == 1) {
                j++; 
                continue;
            }
            int diff = nums[i] - target[j];
            if (diff > 0) ans += (diff / 2);
            i++; j++;
        }
        i = 0; j = 0;
        while (i < n) {
            if ((nums[i] & 1) == 0) {
                i++;
                continue;
            }
            if ((target[j] & 1) == 0) {
                j++; 
                continue;
            }
            int diff = nums[i] - target[j];
            if (diff > 0) ans += (diff / 2);
            i++; j++;
        }
        return ans;
    }
}