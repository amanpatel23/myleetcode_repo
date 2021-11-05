class Solution {
    public int arrangeCoins(int n) {
        
        long l = 1, r = n;
        while (r - l > 1) {
            long mid = l + ((r - l) / 2);
            if (_check(mid, n))
                l = mid;
            else
                r = mid;
        }
        
        long result = (_check(r, n)) ? r : l;
        return (int) result;
    }
    
    static boolean _check(long x, long n) {
        return ((x * (x + 1)) / 2) <= n;
    }
}