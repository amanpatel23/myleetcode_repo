class Solution {
    
    private int lIdx, rIdx;
    public String minWindow(String s, String t) {
        int n1 = s.length(), n2 = t.length();
        if (n2 > n1) return "";
        int[] tFreq = new int[65];
        for (char c : t.toCharArray()) tFreq[c - 'A']++;
        int l = n2, r = n1;
        while (r - l > 1) {
            int mid = l + ((r - l) / 2);
            if (check(mid, s, t, tFreq)) r = mid;
            else l = mid;
        }
        if (check(l, s, t, tFreq) || check(r, s, t, tFreq)) 
            return s.substring(lIdx, rIdx + 1);
        return "";
    }
    
    private boolean check(int window, String s, String t, int[] tFreq) {
        int[] sFreq = new int[65];
        for (int i = 0; i < s.length(); i++) {
            int ascii = s.charAt(i) - 'A';
            if (i < window) {
                sFreq[ascii]++;
                if (i == window - 1) {
                    if (util(tFreq, sFreq)) {
                        lIdx = i - window + 1; rIdx = i;
                        return true;
                    }
                }
            } else {
                sFreq[ascii]++;
                sFreq[s.charAt(i - window) - 'A']--;
                if (util(tFreq, sFreq)) {
                    lIdx = i - window + 1; rIdx = i;
                    return true;
                }
            }
        }
        return false;
    }
    
    private boolean util(int[] tFreq, int[] sFreq) {
        for (int i = 0; i < 65; i++) {
            if (tFreq[i] > sFreq[i]) return false;
        }
        return true;
    }
}