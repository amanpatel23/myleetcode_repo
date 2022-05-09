class Solution {
    
    private static Map<Integer, List<Character>> map;
    private static List<String> list;
    public List<String> letterCombinations(String digits) {
        
        map = Map.of(2, List.of('a', 'b', 'c'), 
                     3, List.of('d', 'e', 'f'), 
                     4, List.of('g', 'h', 'i'), 
                     5, List.of('j', 'k', 'l'), 
                     6, List.of('m', 'n', 'o'), 
                     7, List.of('p', 'q', 'r', 's'), 
                     8, List.of('t', 'u', 'v'), 
                     9, List.of('w', 'x', 'y', 'z')
        );
        
        list = new ArrayList<>();
        solve(0, "", digits);
        return list;
    }
    
    private static void solve(int i, String ans, String digits) {
        if (i == digits.length()) {
            if (ans.length() > 0) list.add(ans);
            return;
        }
        for (char c : map.get(digits.charAt(i) - '0')) 
            solve(i + 1, ans + c, digits);
    }
}