class Solution {
    public int maximalRectangle(char[][] matrix) {
        
        int m = matrix.length;
        if (m == 0)
            return 0;
        int n = matrix[0].length;
        int[][] modified_m = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '0') {
                    continue;
                }
                
                modified_m[i][j] = (j == 0 ? 0 : modified_m[i][j - 1]) + 1;
            }
        }
        
        Stack<Integer> _stack = new Stack<>();
        int[] left = new int[m], right = new int[m];
        
        int result = 0;
        for (int j = 0; j < n; j++) {
            
            // calculating left_limit_idx
            _stack.clear();
            _stack.push(-1);
            for (int i = 0; i < m; i++) {
                while (_stack.size() > 1 && 
                       modified_m[_stack.peek()][j] >= modified_m[i][j])
                    _stack.pop();
                left[i] = _stack.peek() + 1;
                _stack.push(i);
            }
            
            // calculating right_limit_idx
            _stack.clear();
            _stack.push(m);
            for (int i = (m - 1); i >= 0; i--) {
                while (_stack.size() > 1 && 
                       modified_m[_stack.peek()][j] >= modified_m[i][j])
                    _stack.pop();
                right[i] = _stack.peek() - 1;
                _stack.push(i);
            }
            
            int sub_result = 0;
            for (int i = 0; i < m; i++) {
                int curr = (right[i] - left[i] + 1) * modified_m[i][j];
                sub_result = Math.max(sub_result, curr);
            }
            
            result = Math.max(result, sub_result);
        }
        
        return result;
    }
}