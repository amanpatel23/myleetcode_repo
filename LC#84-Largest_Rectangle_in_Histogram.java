class Solution {
    public int largestRectangleArea(int[] heights) {
        
        int n = heights.length;
        Stack<Integer> _stack = new Stack<>();
        int[] left_limit_idx = new int[n], right_limit_idx = new int[n];
        
        // calculating left limit idx
        _stack.push(-1);
        for (int i = 0; i < n; i++) {
            while (_stack.size() > 1 && heights[_stack.peek()] >= heights[i])
                _stack.pop();
            left_limit_idx[i] = _stack.peek() + 1;
            _stack.push(i);
        }
        
        // clearing stack
        _stack.clear();
        // calculating right limit idx
        _stack.push(n);
        for (int i = n - 1; i >= 0; i--) {
            while (_stack.size() > 1 && heights[_stack.peek()] >= heights[i])
                _stack.pop();
            right_limit_idx[i] = _stack.peek() - 1;
            _stack.push(i);
        }
        
        int result = 0;
        for (int i = 0; i < n; i++) {
            int curr = (right_limit_idx[i] - left_limit_idx[i] + 1) * heights[i];
            result = Math.max(result, curr);
        }
        
        return result;
    }
}