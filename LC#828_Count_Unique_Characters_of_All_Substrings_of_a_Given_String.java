class Solution {
    public int uniqueLetterString(String s) {
        
        int[][] latest_occu = new int[26][2];
        for (int[] r : latest_occu) Arrays.fill(r, -1);
        int ans = 0, prev = 0;
        for (int i = 0; i < s.length(); i++) {
            int ascii = s.charAt(i) - 'A';
            int curr = prev + (i - latest_occu[ascii][0]) - 
                (latest_occu[ascii][0] - latest_occu[ascii][1]);
            ans += curr;
            prev = curr;
            
            latest_occu[ascii][1] = latest_occu[ascii][0];
            latest_occu[ascii][0] = i;
        }
        
        return ans;
    }
}