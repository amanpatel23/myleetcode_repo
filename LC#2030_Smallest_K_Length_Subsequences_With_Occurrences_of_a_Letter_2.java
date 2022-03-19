class Solution {
    public String smallestSubsequence(String s, int k, char l, int r) {
        
        int n = s.length();
        int[] l_freq = new int[n];
        for (int i = 0; i < n; i++) {
            l_freq[i] = (i == 0 ? 0 : l_freq[i - 1]) + (s.charAt(i) == l ? 1 : 0);
        }
        
        Stack<Character> stack = new Stack<>();
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            while (!stack.isEmpty()) {
                if ((k - stack.size() + 1) > (n - i))
                    break;
                if (stack.peek() <= c)
                    break;
                if (stack.peek() == l) {
                    int temp = l_freq[n - 1] - l_freq[i] + (c == l ? 1 : 0);
                    if ((r - cnt + 1) > temp)
                        break;
                }
                
                if (stack.pop() == l) cnt--;
            }
            
            if (stack.size() < k) {
                if (c == l) {
                    stack.add(c);
                    cnt++;
                }else if ((k - stack.size() - 1) >= (r - cnt)) {
                    stack.add(c);
                }
            }
        }
        
        StringBuilder result = new StringBuilder();
        while (!stack.isEmpty()) result.append(stack.pop());
        return result.reverse().toString();
    }
}