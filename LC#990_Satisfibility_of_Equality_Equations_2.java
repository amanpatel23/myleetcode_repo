class Solution {
    public boolean equationsPossible(String[] equations) {
        
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < 26; i++) adjList.add(new ArrayList<>());
        List<int[]> notMatching = new ArrayList<>();
        
        for (String str : equations) {
            int ff = str.charAt(0) - 'a', ss = str.charAt(3) - 'a';
            char sign = str.charAt(1);
            if (sign == '=') {
                adjList.get(ff).add(ss);
                adjList.get(ss).add(ff);
            } else notMatching.add(new int[]{ff, ss});
        }
        
        int[] color_assigned = new int[26];
        int next_color = 1;
        for (int i = 0; i < 26; i++) {
            if (color_assigned[i] > 0) continue;
            Stack<Integer> stack = new Stack<>();
            stack.add(i);
            while (!stack.isEmpty()) {
                int top = stack.pop();
                color_assigned[top] = next_color;
                for (int x : adjList.get(top)) {
                    if (color_assigned[x] == 0) stack.add(x);
                }
            }
            
            next_color++;
        }
        
        for (int[] arr : notMatching) 
            if (color_assigned[arr[0]] == color_assigned[arr[1]]) return false;
        return true;
    }
}