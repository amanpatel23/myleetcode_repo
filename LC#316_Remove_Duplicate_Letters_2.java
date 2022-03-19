class Solution {
    public String removeDuplicateLetters(String s) {
        
        int mask = 0;
        int[] last_occ = new int[26];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int idx = c - 'a';
            mask |= (1 << idx);
            last_occ[idx] = i;
        }
        
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int idx = c - 'a';
            if (((mask >> idx) & 1) == 0) continue;
            while (!stack.isEmpty() && stack.peek() > c && 
                   last_occ[stack.peek() - 'a'] > i) {
                char top = stack.pop();
                int temp_idx = top - 'a';
                mask |= (1 << temp_idx);
            }
            stack.add(c);
            mask ^= (1 << idx);
        }
        
        StringBuilder result = new StringBuilder();
        while (!stack.isEmpty())
            result.append(stack.pop());
        return result.reverse().toString();
    }
}