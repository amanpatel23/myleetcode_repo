class Solution {
    public String robotWithString(String s) {

        int n = s.length();
        Stack<Integer> stack = new Stack<>();
        StringBuilder ans = new StringBuilder();
        int[] freq = new int[26];
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }
        int i = 0;
        int idx = 0;
        while (freq[idx] == 0) idx++;
        while (i < n && idx < 26) {
            while (i < n) {
                int ascii = s.charAt(i) - 'a';
                stack.add(ascii);
                freq[ascii]--;
                i++;
                if (ascii == idx) break;
            }
            while (idx < 26 && freq[idx] == 0) idx++;
            while (!stack.isEmpty() && stack.peek() <= idx) {
                ans.append((char) (stack.pop() + 'a'));
            }
        }

        while (!stack.isEmpty()) ans.append((char) (stack.pop() + 'a'));
        return ans.toString();
    }
}