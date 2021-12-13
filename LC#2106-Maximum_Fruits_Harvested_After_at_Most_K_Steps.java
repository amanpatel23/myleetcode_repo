class Solution {
    
    public int maxTotalFruits(int[][] fruits, int st, int k) {
        
        int n = fruits.length;
        int[] prefixSum = new int[n];
        for (int i = 0; i < n; i++) {
            prefixSum[i] = fruits[i][1] + (i == 0 ? 0 : prefixSum[i - 1]);
        }
        
        List<Pair> ranges = new ArrayList<>();
        int x = 0;
        while (x <= k) {
            int left = st - x;
            int y = k - x;
            int right = Math.max(st, left + y);
            ranges.add(new Pair(left, right));
            x++;
        }
        
        x = 0;
        while (x <= k) {
            int right = st + x;
            int y = k - x;
            int left = Math.min(st, right - y);
            ranges.add(new Pair(left, right));
            x++;
        }
        
        int result = 0;
        for (int i = 0; i < ranges.size(); i++) {
            int ff = ranges.get(i).x;
            int ss = ranges.get(i).y;
            
            int l = 0, r = n - 1;
            while (r - l > 1) {
                int mid = l + ((r - l) / 2);
                if (_check1(fruits, mid, ff))
                    r = mid;
                else
                    l = mid;
            }
            
            int idx1 = -1;
            if (_check1(fruits, l, ff))
                idx1 = l;
            else if (_check1(fruits, r, ff))
                idx1 = r;
            
            l = 0;
            r = n - 1;
            while (r - l > 1) {
                int mid = l + ((r - l) / 2);
                if (_check2(fruits, mid, ss))
                    l = mid;
                else
                    r = mid;
            }
            
            int idx2 = -1;
            if (_check2(fruits, r, ss))
                idx2 = r;
            else if (_check2(fruits, l, ss))
                idx2 = l;
            
            if (idx1 != -1 && idx2 != -1) {
                int curr = prefixSum[idx2] - (idx1 == 0 ? 0 : prefixSum[idx1 - 1]);
                result = Math.max(result, curr);
            }
        }
        
        return result;
    }
    
    private static boolean _check1(int[][] fruits, int i, int x) {
        return (fruits[i][0] >= x);
    }
    
    private static boolean _check2(int[][] fruits, int i, int x) {
        return (fruits[i][0] <= x);
    }
    
    private static class Pair {
        int x, y;
        Pair(int _x, int _y) {
            this.x = _x;
            this.y = _y;
        }
    }
}