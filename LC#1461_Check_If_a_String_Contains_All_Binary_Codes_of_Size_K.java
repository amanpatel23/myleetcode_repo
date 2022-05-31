class Solution {
    public boolean hasAllCodes(String s, int k) {
        int n = s.length();
        if (n < k) return false;
        boolean[] is_present = new boolean[1 << k];
        int hash = 0, power = 1;
        for (int i = k - 1; i >= 0; i--) {
            if (s.charAt(i) == '1') 
                hash += power;
            power *= 2;
        }
        is_present[hash] = true;
        for (int i = k; i < n; i++) {
            hash *= 2;
            if (s.charAt(i - k) == '1')
                hash -= power;
            if (s.charAt(i) == '1')
                hash += 1;
            is_present[hash] = true;
        }
        for (int i = 0; i < (1 << k); i++) {
            if (!is_present[i])
                return false;
        }
        return true;
    }
}