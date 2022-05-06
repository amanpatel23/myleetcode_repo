class Solution {
    public long countVowels(String word) {
        
        Set<Character> vowels = new HashSet(List.of('a', 'e', 'i', 'o', 'u'));
        long ans = 0, prev = 0;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            long curr = prev + (vowels.contains(c) ? (i + 1) : 0);
            ans += curr;
            prev = curr;
        }
        
        return ans;
    }
}