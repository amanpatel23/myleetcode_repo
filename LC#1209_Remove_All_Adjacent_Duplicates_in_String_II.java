class Solution {
    public String removeDuplicates(String s, int k) {
        
        Stack<int[]> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            int curr = 0;
            if (stack.isEmpty() || stack.peek()[0] != (c - 'a')) curr = 1;
            else curr = stack.peek()[1] + 1;
            if (curr == k) {
                while (!stack.isEmpty() && stack.peek()[0] == (c - 'a')) stack.pop();
            } else stack.add(new int[]{(c - 'a'), curr});
        }
        
        StringBuilder result = new StringBuilder();
        while (!stack.isEmpty()) result.append((char) (stack.pop()[0] + 'a'));
        return result.reverse().toString();
    }
}