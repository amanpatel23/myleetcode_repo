class Solution {
    public long countGood(int[] nums, int k) {

        long pairs = 0;
        int i = 0;
        Map<Integer, Integer> map = new HashMap<>();
        int j = 0;
        long ans = 0;
        for (int num : nums) {
            if (map.containsKey(num)) {
                long vv = map.get(num);
                long temp = vv * (vv - 1) / 2;
                pairs -= temp;
            }
            map.put(num, map.getOrDefault(num, 0) + 1);
            long vv = map.get(num);
            long temp = vv * (vv - 1) / 2;
            pairs += temp;
            
            long xx = pairs;
            while (i < j) {
                int curr = nums[i];
                vv = map.get(curr);
                temp =  vv * (vv - 1) / 2;
                xx -= temp;
                temp = (vv - 1) * (vv - 2) / 2;
                xx += temp;
                if (xx >= k) {
                    map.put(curr, map.get(curr) - 1);
                    if (map.get(curr) == 0) {
                        map.remove(curr);
                    }
                    pairs = xx;
                    i++;
                } else {
                    break;
                }
            }
            
            if (pairs >= k) ans += (i + 1);
            j++;
        }
        return ans;
    }
}