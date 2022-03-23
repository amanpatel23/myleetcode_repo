class Solution {
    public int brokenCalc(int s, int t) {
        
        int x = t, y = s;
        int cnt = 0;
        while (x != y) {
            if (x < y) {
                cnt += (y - x);
                x = y;
            }else if ((x & 1) == 1) {
                cnt++;
                x++;
            }else {
                cnt++;
                x /= 2;
            }
        }
        
        return cnt;
    }
}