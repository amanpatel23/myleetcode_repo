class Solution {
    public boolean canConvertString(String s, String t, int k) {
        int n1 = s.length(), n2 = t.length();
        if (n1 != n2) return false;
        int[] temp = new int[26];
        for (int i = 0; i < n1; i++) {
            int ascii1 = s.charAt(i) - 'a', ascii2 = t.charAt(i) - 'a';
            int op = ((ascii2 - ascii1 + 26) % 26);
            if (op == 0) continue;
            long curr = op + (26 * temp[op]);
            if (curr > k) return false;
            temp[op]++;
        }
        return true;
    }
}