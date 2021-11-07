class Solution {
    public int minimizedMaximum(int n, int[] quantities) {
        
        int m = quantities.length;
        int l = 1, r = 1;
        for (int i = 0; i < m; i++)
            r = Math.max(r, quantities[i]);
        
        while (r - l > 1) {
            int mid = l + ((r -l) / 2);
            if (_check(m, quantities, n, mid))
                r = mid;
            else
                l = mid;
        }
        
        int result = (_check(m, quantities, n, l) ? l : r);
        return result;
    }
    
    private static boolean _check(int m, int[] quantities, int n, int x) {
        int cnt = 0;
        for (int i = 0; i < m; i++) {
            cnt += ((quantities[i] + x - 1) / x);
        }
        
        return (cnt <= n);
    }
}