class Solution {
    public int countSubarrays(int[] nums, int k) {

        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int i = 0;
        for (; i < nums.length; i++) {
            if (nums[i] == k) break;
        }
        int ff = 0, ss = 0;
        for (int ii = i - 1; ii >= 0; ii--) {
            if (nums[ii] > k) ff++;
            else ss++;
            int diff = ff - ss;
            map.put(diff, map.getOrDefault(diff, 0) + 1);
        }
        // System.out.println(map);
        int ans = 0;
        ff = 0; ss = 0;
        for (int ii = i; ii < nums.length; ii++) {
            if (nums[ii] > k) ff++;
            else if (nums[ii] < k) ss++;
            int diff = ff - ss;
            if (diff == 0) {
                ans += map.getOrDefault(0, 0);
                ans += map.getOrDefault(1, 0);
            } else {
                ans += map.getOrDefault(-diff, 0);
                ans += map.getOrDefault(-(diff - 1), 0);
            }
        }
        return ans;
    }
}