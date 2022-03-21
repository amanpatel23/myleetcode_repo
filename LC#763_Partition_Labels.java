class Solution {
    public List<Integer> partitionLabels(String s) {
        
        int n = s.length();
        int[] last_occu = new int[26];
        for (int i = 0; i < n; i++)
            last_occu[s.charAt(i) - 'a'] = i;
        
        List<Integer> result = new ArrayList<>();
        int max = -1, cnt = 0;
        for (int i = 0; i < n; i++) {
            cnt++;
            max = Math.max(max, last_occu[s.charAt(i) - 'a']);
            if (max == i) {
                result.add(cnt);
                max = -1;
                cnt = 0;
            }
        }
        
        return result;
    }
}