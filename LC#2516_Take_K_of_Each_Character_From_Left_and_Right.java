class Solution {
    public int takeCharacters(String s, int k) {
        if (k == 0) return 0;
        int n = s.length();
        int ii = n - 1;
        int[] arr = new int[3];
        for (; ii >= 0; ii--) {
            arr[s.charAt(ii) - 'a']++;
            if (Math.min(arr[0], Math.min(arr[1], arr[2])) >= k) {
                break;
            }
        }
        if (ii == -1) return -1;
        int ans = n - ii;
        for (int i = 0; i < n; i++) {
            arr[s.charAt(i) - 'a']++;
            while (ii < n && arr[s.charAt(ii) - 'a'] > k) {
                arr[s.charAt(ii) - 'a']--;
                ii++;
            }
            ans = Math.min(ans, i + 1 + n - ii);
        }
        
        return ans;
    }
}