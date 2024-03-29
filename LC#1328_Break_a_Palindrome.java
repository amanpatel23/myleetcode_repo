class Solution {
    public String breakPalindrome(String palindrome) {
        int n = palindrome.length();
        if (n == 1) return "";
        int idx = -1;
        char[] arr = palindrome.toCharArray();
        for (int i = 0; i < (n / 2); i++) {
            if (arr[i] != 'a') {
                idx = i;
                break;
            }
        }
        
        if (idx == -1) arr[n - 1] = 'b';
        else arr[idx] = 'a';
        return String.valueOf(arr);
    }
}