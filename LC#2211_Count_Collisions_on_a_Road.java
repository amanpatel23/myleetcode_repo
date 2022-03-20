class Solution {
    public int countCollisions(String dir) {

        int n = dir.length();
        int result = 0;
        Stack<Character> stack = new Stack<>();
        for (char c : dir.toCharArray()) {
            char curr = c;
            while (!stack.isEmpty()) {
                if (curr == 'R') break;
                else if (curr == 'L') {
                    if (stack.peek() == 'L') break;
                    char top = stack.pop();
                    if (top == 'R') {
                        result += 2;
                    }else {
                        result += 1;
                    }
                    curr = 'S';
                }else {
                    if (stack.peek() == 'L' || stack.peek() == 'S') break;
                    stack.pop();
                    result += 1;
                }
            }
            
            stack.add(curr);
        }
        
        return result;
    }
}