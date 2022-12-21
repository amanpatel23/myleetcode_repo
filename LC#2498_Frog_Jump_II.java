class Solution {
    public int maxJump(int[] stones) {
        
        int n = stones.length;
        if (n <= 3) {
            return stones[n - 1] - stones[0];
        }
        
        int l = stones[1] - stones[0], r = stones[n - 1] - stones[0];
        while (r - l > 1) {
            int mid = l + ((r - l) / 2);
            if (check(stones, mid)) r = mid;
            else l = mid;
        }
        if (check(stones, l)) return l;
        return r;
    }
    
    private static boolean check(int[] stones, int x) {
        if (stones.length <= 3) {
            return (stones[stones.length - 1] - stones[0] <= x);
        }
        
        int ii = 0;
        List<Integer> list = new ArrayList<>();
        list.add(stones[0]);
        int i = 1;
        while (i < stones.length) {
            if (stones[i] - stones[ii] > x) {
                if (ii == i - 1) return false;
                ii = i - 1;
                
                list.remove(list.size() - 1);
            } else {
                list.add(stones[i]);
                i++;
            }
        }
        
        if (list.size() <= 2) {
            return list.get(1) - list.get(0) <= x;
        }
        
        ii = 0;
        i = 1;
        while (i < list.size()) {
            if (list.get(i) - list.get(ii) > x) {
                if (ii == i - 1) return false;
                ii = i - 1;
            } else i++;
        }
        
        return true;
    }
}