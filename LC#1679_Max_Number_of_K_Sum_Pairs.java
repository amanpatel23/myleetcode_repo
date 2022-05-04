class Solution {
    public int maxOperations(int[] nums, int k) {
        
        Map<Integer, Integer> map = new HashMap<>();
        int ans = 0;
        for (int ff : nums) {
            int ss = k - ff;
            if (map.getOrDefault(ss, 0) > 0) {
                ans++;
                map.put(ss, map.get(ss) - 1);
            }else {
                map.put(ff, map.getOrDefault(ff, 0) + 1);
            }
        }
        
        return ans;
    }
}