class Solution {
    public long countVowels(String word) {

        int n = word.length();
        long[] prefixSum = new long[n + 1];
        long[] suffixSum = new long[n + 2];
        for (int i = 1; i <= n; i++) {
            char _char = word.charAt(i - 1);
            prefixSum[i] = prefixSum[i - 1] + (isVowel(_char) ? 1 : 0);
        }

        for (int i = n; i > 0; i--) {
            suffixSum[i] = suffixSum[i + 1] + prefixSum[i];
        }

        long result = 0;
        long x = n;
        for (int i = 1; i <= n; i++) {
            result += (suffixSum[i] - (x * prefixSum[i - 1]));
            x--;
        }

        return result;
    }

    private static boolean isVowel(char _char) {
        return (_char == 'a' || _char == 'e' || _char == 'i' || _char == 'o' || _char == 'u');
    }
}