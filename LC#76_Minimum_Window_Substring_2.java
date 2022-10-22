class Solution {
    public String minWindow(String s, String t) {
        
        if (t.length() > s.length()) return "";
        int[] tFreq = new int[65];
        int cnt = 0;
        for (char c : t.toCharArray()) {
            tFreq[c - 'A']++;
            if (tFreq[c - 'A'] == 1) cnt++;
        }
        int i = 0, j = 0, x = cnt;
        int lIdx = -1, rIdx = -1, minSize = s.length();
        int[] tFreqCopy = tFreq.clone();
        while (j < s.length()) {
            while (j < s.length() && x > 0) {
                int ascii = s.charAt(j) - 'A';
                tFreqCopy[ascii]--;
                if (tFreqCopy[ascii] == 0) x--;
                j++;
            }
            if (x == 0) {
                while (x == 0) {
                    int ascii = s.charAt(i) - 'A';
                    tFreqCopy[ascii]++;
                    if (tFreqCopy[ascii] == 1) x++;
                    i++;
                }
                if (minSize >= (j - i)) {
                    lIdx = i - 1; rIdx = j;
                    minSize = j - i;
                }
            }
        }
        if (lIdx == -1) return "";
        return s.substring(lIdx, rIdx);
    }
}