class Solution {
    public int lengthOfLIS(int[] nums) {
        
        List<Integer> list = new ArrayList<>();
        for (int num: nums) {
            if (list.isEmpty() || list.get(list.size() - 1) < num)
                list.add(num);
            else {
                int idx = lower_bound(0, list.size() - 1, list, num);
                list.set(idx, num);
            }
        }
        
        return list.size();
    }
    
    private static int lower_bound(int l, int r, List<Integer> list, int val) {
        while (r - l > 1) {
            int mid = (l + r) / 2;
            if (list.get(mid) >= val)
                r = mid;
            else
                l = mid;
        }
        if (list.get(l) >= val)
            return l;
        if (list.get(r) >= val)
            return r;
        return -1;
    }
}