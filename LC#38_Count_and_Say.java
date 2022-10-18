class Solution {
    public String countAndSay(int n) {
        String ans = "1";
        for (int i = 2; i <= n; i++) {
            StringBuilder curr = new StringBuilder();
            char prev = ans.charAt(0);
            int cnt = 0;
            for (int ii = 0; ii < ans.length(); ii++) {
                if (ans.charAt(ii) == prev) {
                    cnt++;
                    continue;
                }
                curr.append(cnt).append(prev);
                prev = ans.charAt(ii);
                cnt = 1;
            }
            curr.append(cnt).append(prev);
            ans = curr.toString();
        }
        return ans;
    }
}