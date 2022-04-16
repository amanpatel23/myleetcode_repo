class Solution {
    public String minRemoveToMakeValid(String s) {
        
        Stack<Integer> stack = new Stack<>();
        List<Integer> to_remove = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') stack.add(i);
            else if (s.charAt(i) == ')' && !stack.isEmpty()) stack.pop();
            else if (s.charAt(i) == ')') to_remove.add(i);
        }
        while (!stack.isEmpty()) to_remove.add(stack.pop());
        Collections.sort(to_remove);
        
        StringBuilder result = new StringBuilder();
        int idx = 0;
        for (int i = 0; i < s.length(); i++) {
            if (idx >= to_remove.size() || i != to_remove.get(idx)) {
                result.append(s.charAt(i));
                continue;
            }
            idx++;
        }
        
        return result.toString();
    }
}