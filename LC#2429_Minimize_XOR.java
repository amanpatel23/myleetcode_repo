class Solution {
    public int minimizeXor(int num1, int num2) {

        int set_bits = noOfSetBits(num2);
        int ans = 0;
        for (int bit = 31; bit >= 0; bit--) {
            if (set_bits == 0) break;
            if (((num1 >> bit) & 1) == 1) {
                ans |= (1 << bit);
                set_bits--;
            }
        }
        for (int bit = 0; bit < 32; bit++) {
            if (set_bits == 0) break;
            if (((num1 >> bit) & 1) == 0) {
                ans |= (1 << bit);
                set_bits--;
            }
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