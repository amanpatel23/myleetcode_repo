class Solution {
    public long appealSum(String s) {
        
        int[] latest_occu = new int[26];
        Arrays.fill(latest_occu, -1);
        long result = 0;
        long prev = 0;
        for (int i = 0; i < s.length(); i++) {
            int ascii = s.charAt(i) - 'a';
            long curr = prev + i - latest_occu[ascii];
            result += curr;
            latest_occu[ascii] = i;
            prev = curr;
        }
        
        return result;
    }
}