class Solution {
    public int longestValidParentheses(String s) {
        
        int n = s.length();
        Stack<Integer> _stack = new Stack<>();
        _stack.push(-1);
        int result = 0;
        for (int i = 0; i < n; i++) {
            char bra = s.charAt(i);
            if (bra == '(') {
                _stack.push(i);
                continue;
            }
            
            if (_stack.peek() == -1 || (s.charAt(_stack.peek()) == ')')) {
                _stack.push(i);
                continue;
            }
            
            _stack.pop();
            result = Math.max(result, (i - _stack.peek()));
        }
        
        return result;
    }
}