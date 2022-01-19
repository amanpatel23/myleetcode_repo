class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        
        Map<Character, Integer> map = Map.of('A', 0, 'C', 1, 'G', 2, 'T', 3);
        
        Set<Integer> visited = new HashSet<>(), visited_double = new HashSet<>();
        List<String> result = new ArrayList<>();
        
        int len = s.length();
        for (int i = 0; (i + 9) < len; i++) {
            int mask = 0;
            for (int j = i; j < (i + 10); j++) {
                mask <<= 2;
                mask |= (map.get(s.charAt(j)));
            }
            if (!visited.add(mask) && visited_double.add(mask))
                result.add(s.substring(i, i + 10));
        }
        
        return result;
    }
}