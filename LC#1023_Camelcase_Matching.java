class Solution {
    public List<Boolean> camelMatch(String[] queries, String pattern) {
        
        List<Boolean> ans = new ArrayList<>();
        for (String str : queries) {
            ans.add(util(str, pattern));
        }
        return ans;
    }
    
    private boolean util(String str, String pattern) {
        int n1 = str.length(), n2 = pattern.length();
        if (n2 > n1) return false;
        int cnt1 = 0, cnt2 = 0;
        for (char c : str.toCharArray()) {
            if (c >= 'A' && c <= 'Z') cnt1++;
        }
        for (char c : pattern.toCharArray()) {
            if (c >= 'A' && c <= 'Z') cnt2++;
        }
        if (cnt1 > cnt2) return false;
        int i = 0, j = 0;
        while (i < n1 && j < n2) {
            if (str.charAt(i) == pattern.charAt(j)) {
                i++; 
                j++;
            } else i++;
        }
        return (j == n2);
    }
}