class Solution {
    public int countWords(String[] words1, String[] words2) {

        Set<String> string_set = new HashSet<>();
        string_set.addAll(Arrays.asList(words1));
        string_set.addAll(Arrays.asList(words2));
        Map<String, Integer> _map1 = new HashMap<>(), _map2 = new HashMap<>();
        for (String str: string_set) {
            _map1.put(str, 0);
            _map2.put(str, 0);
        }

        for (String str: words1)
            _map1.put(str, _map1.get(str) + 1);
        for (String str: words2)
            _map2.put(str, _map2.get(str) + 1);

        int result = 0;
        for (String str: string_set) {
            if (_map1.get(str) == 1 && _map2.get(str) == 1)
                result++;
        }

        return result;
    }
}