class Solution {
    public int maxProduct(String[] words) {
        int n = words.length;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            int num = 0;
            for (char c : words[i].toCharArray()) {
                num |= (1 << (c - 'a'));
            }
            arr[i] = num;
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if ((arr[i] & arr[j]) == 0) 
                    ans = Math.max(ans, words[i].length() * words[j].length());
            }
        }
        return ans;
    }
}