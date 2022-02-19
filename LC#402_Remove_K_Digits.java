class Solution {
    public String removeKdigits(String num, int _k) {
        
        int k = _k;
        Stack<Integer> stack = new Stack<>();
        for (char c : num.toCharArray()) {
            int d = c - '0';
            if (stack.empty() && d == 0)
                continue;
            if (k == 0) {
                stack.push(d);
                continue;
            }
            
            while (!stack.empty() && (stack.peek() > d) && (k > 0)) {
                stack.pop();
                k--;
            }
            
            if (stack.empty() && d == 0)
                continue;
            stack.push(d);
        }
        
        while (!stack.empty() && (k > 0)) {
            stack.pop();
            k--;
        }
        
        StringBuilder result = new StringBuilder();
        while (!stack.empty())
            result.append(stack.pop());
        
        if (result.length() == 0)
            return "0";
        return result.reverse().toString();
    }
}