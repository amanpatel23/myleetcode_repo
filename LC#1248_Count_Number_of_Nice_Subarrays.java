class Solution {
    private static Map<Integer, Integer> first_occu;
    private static int[] prefix_odd;
    public int numberOfSubarrays(int[] nums, int k) {
        int n = nums.length;
        first_occu = new HashMap<>();
        prefix_odd = new int[n];
        first_occu.put(0, -1);
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            prefix_odd[i] = i > 0 ? prefix_odd[i - 1] : 0;
            if ((nums[i] & 1) == 1) {
                first_occu.put(++cnt, i);
                ++prefix_odd[i];
            }
        }
        
        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans += util(i, nums, k);
            ans -= util(i, nums, k - 1);
        }
        return ans;
    }
    
    private static int util(int i, int[] nums, int k) {
        int idx = first_occu.get(Math.max(0, prefix_odd[i] - k));
        return (i - idx);
    }
}