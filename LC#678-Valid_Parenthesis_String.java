class Solution {
    public boolean checkValidString(String s) {
        
        int n = s.length();
        Stack<Integer> ope = new Stack<>(), stars = new Stack<>();
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '(')
                ope.push(i);
            else if (s.charAt(i) == '*')
                stars.push(i);
            else {
                if (!ope.isEmpty()) {
                    ope.pop();
                    continue;
                }
                
                if (!stars.isEmpty()) {
                    stars.pop();
                    continue;
                }
                
                return false;
            }
        }
        
        while (!ope.isEmpty()) {
            if (stars.isEmpty())
                return false;
            int i = ope.pop();
            int j = stars.pop();
            if (i > j)
                return false;
        }
        
        return true;
    }
}