class Solution {
    
    private long lcm;
    public int minimizeSet(int d1, int d2, int u1, int u2) {
        
        lcm = lcm(d1, d2);
        long l = 1, r = (long) (1e15);
        while (r - l > 1) {
            long mid = l + ((r - l) / 2);
            if (check(mid, d1, d2, u1, u2, lcm)) {
                r = mid;
            } else {
                l = mid;
            }
        }
        
        if (check(l, d1, d2, u1, u2, lcm)) {
            return (int) l;
        }
        return (int) r;
    }
    
    private boolean check(long x, int d1, int d2, int u1, int u2, long lcm) {
        if (d1 == d2) {
            x = x - x / d1;
            return (u1 + u2 <= x);
        }
        
        long cnt1 = (x / d1) - (x / lcm);
        long cnt2 = (x / d2) - (x / lcm);
        u1 -= Math.min(u1, cnt2);
        u2 -= Math.min(u2, cnt1);
        long rem = x - cnt1 - cnt2 - (x / lcm);
        return (u1 + u2 <= rem);
    }
    
    private long gcd(long a, long b) {
        return (b == 0 ? a : gcd(b, a % b));
    }

    private long lcm(long a, long b) {
        return ((a * b) / gcd(a, b));
    }
}