class Solution {
    public int maxVowels(String s, int k) {

        Set<Character> vowels = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));
        Queue<Character> qq = new LinkedList<>();
        int global = 0, current = 0, len = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            qq.add(c);
            len++;
            
            if (vowels.contains(c))
                current++;

            while (len > k) {
                char removed = qq.remove();
                if (vowels.contains(removed))
                    current--;
                len--;
            }

            global = Math.max(global, current);
        }

        return global;
    }
}