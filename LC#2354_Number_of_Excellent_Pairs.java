class Solution {
    public long countExcellentPairs(int[] nums, int k) {

        int n = nums.length;
        List<Integer> list = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) continue;
            list.add(noOfSetBits(num));
            set.add(num);
        }
        int len = list.size();
        Collections.sort(list);
        
        long ans = 0;
        set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) continue;
            set.add(num);
            int set_bits = noOfSetBits(num);
            int left = Math.max(0, k - set_bits);
            
            int l = 0, r = len - 1;
            while (r - l > 1) {
                int mid = l + ((r - l) / 2);
                if (list.get(mid) >= left)
                    r = mid;
                else
                    l = mid;
            }
            int idx = -1;
            if (list.get(l) >= left) idx = l;
            else if (list.get(r) >= left) idx = r;
            if (idx == -1) continue;
            
            ans += (len - idx);
        }
        return ans;
    }
    
    private static int noOfSetBits(long x) {
        int cnt = 0;
        while (x != 0) {
            x = x & (x - 1);
            cnt++;
        }
        return cnt;
    }
}