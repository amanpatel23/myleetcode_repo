class Solution {
    public String subStrHash(String s, int p, int mod, int k, int hashValue) {
       
        int n = s.length();
        
        long sum = 0;
        long temp = p;
        int idx = 0;
        for (int i = (n - 1); i >= 0; i--) {
            
            sum = ((sum * p) + (s.charAt(i) - 'a' + 1)) % mod;
            if (i <= (n - k)) {
                if (i < (n - k)) {
                    sum = ((sum - ((s.charAt(i + k) - 'a' + 1) * temp) % mod) + mod)
                        % mod;
                }
                
                if (sum == hashValue)
                    idx = i;
            }else
                temp = (temp * p) % mod;
        }
        
        return s.substring(idx, idx + k);
    }
}