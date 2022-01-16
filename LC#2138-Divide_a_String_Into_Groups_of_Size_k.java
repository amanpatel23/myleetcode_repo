class Solution {
    public String[] divideString(String s, int k, char fill) {

        int n = s.length();
        int div = (n + k - 1) / k;
        String[] result = new String[div];
        int i = 0;
        int idx = 0;
        while (i < n) {
            int count = 0;
            StringBuilder temp = new StringBuilder();
            while (i < n && count < k) {
                temp.append(s.charAt(i));
                i++;
                count++;
            }
            while (temp.length() < k)
                temp.append(fill);
            result[idx] = temp.toString();
            idx++;
        }
        
        return result;
    }
}