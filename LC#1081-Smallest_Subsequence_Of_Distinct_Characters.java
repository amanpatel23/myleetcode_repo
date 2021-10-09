class Solution {
    public String smallestSubsequence(String s) {
        int[] lastIdx = new int[26];
        for (int i = 0; i < s.length(); i++) {
            lastIdx[s.charAt(i) - 'a'] = i;
        }

        boolean[] seen = new boolean[26];
        Arrays.fill(seen, false);

        Stack<Integer> stack = new Stack();

        for (int i = 0; i < s.length(); i++) {
            int ascii = s.charAt(i) - 'a';
            if (seen[ascii])
                continue;
            while (!stack.isEmpty()&&stack.peek() > ascii&&lastIdx[stack.peek()] > i) {
                seen[stack.pop()] = false;
            }

            stack.push(ascii);
            seen[ascii] = true;
        }
        
        StringBuilder result = new StringBuilder();
        while (!stack.empty()) {
            result.append((char) (stack.pop() + 'a'));
        }
        
        return result.reverse().toString();
    }
}