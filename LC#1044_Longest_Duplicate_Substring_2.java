class Solution {
    
    private static final int mod = (int) (1e9 + 7), p = 37;
    private static String s;
    private static int n;
    public String longestDupSubstring(String _s) {
        
        s = _s;
        n = s.length();
        
        int l = 1, r = n - 1;
        while (r - l > 1) {
            int mid = l + ((r - l) / 2);
            if (check(mid).length() > 0)
                l = mid;
            else
                r = mid;
        }
        
        String str1 = check(r), str2 = check(l);
        return (str1.length() > 0 ? str1 : str2);
    }
    
    private static String check(int x) {
        
        Map<Long, List<Integer>> map = new HashMap<>();
        long hash = 0;
        long power = 1;
        for (int i = x - 1; i >= 0; i--) {
            hash = (hash + (((s.charAt(i) - 'a' + 1) * power) % mod)) % mod;
            power = (power * p) % mod;
        }
        map.put(hash, new ArrayList<>());
        map.get(hash).add(0);
        
        for (int i = x; i < n; i++) {
            hash = (hash * p) % mod;
            hash = (hash - (((s.charAt(i - x) - 'a' + 1) * power) % mod) + mod) % mod;
            hash = (hash + (s.charAt(i) - 'a' + 1)) % mod;
            
            if (map.containsKey(hash)) {
                String str1 = s.substring(i - x + 1, i + 1);
                for (int idx : map.get(hash)) {
                    String str2 = s.substring(idx, idx + x);
                    if (str1.compareTo(str2) == 0)
                        return str1;
                }
            }
            if (!map.containsKey(hash))
                map.put(hash, new ArrayList<>());
            map.get(hash).add(i - x + 1);
        }
        
        return "";
    }
}