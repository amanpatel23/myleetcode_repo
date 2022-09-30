class Solution {
    public List<Integer> goodIndices(int[] nums, int k) {
        
        int n = nums.length;
        int[] prefix = new int[n], suffix = new int[n];
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                prefix[i] = 1;
                continue;
            }
            if (nums[i - 1] >= nums[i]) prefix[i] = 1 + prefix[i - 1];
            else prefix[i] = 1;
        }
        
        for (int i = n - 1; i >= 0; i--) {
            if (i == n - 1) {
                suffix[i] = 1;
                continue;
            }
            if (nums[i + 1] >= nums[i]) suffix[i] = 1 + suffix[i + 1];
            else suffix[i] = 1;
        }
        
        List<Integer> list = new ArrayList<>();
        for (int i = k; i + k < n; i++) {
            if (prefix[i - 1] >= k && suffix[i + 1] >= k) list.add(i);
        }
        return list;
    }
}