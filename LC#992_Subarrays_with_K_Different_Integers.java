class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        int n = nums.length;
        int ans = 0;
        int idx1 = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            while (map.size() > k) {
                map.put(nums[idx1], map.get(nums[idx1]) - 1);
                if (map.get(nums[idx1]) == 0) map.remove(nums[idx1]);
                idx1++;
            }
            if (map.size() == k) {
                Map<Integer, Integer> temp_map = new HashMap<>();
                int idx2 = idx1;
                while (true) {
                    temp_map.put(nums[idx2], temp_map.getOrDefault(nums[idx2], 0) + 1);
                    if (map.get(nums[idx2]) == temp_map.get(nums[idx2])) break;
                    idx2++;
                }
                
                ans += (idx2 - idx1 + 1);
            }
        }
        
        return ans;
    }
}