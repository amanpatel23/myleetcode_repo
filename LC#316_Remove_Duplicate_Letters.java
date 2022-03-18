class Solution {
    
    private static List<List<Integer>> indexes;
    public String removeDuplicateLetters(String s) {
        
        indexes = new ArrayList<>();
        for (int i = 0; i < 26; i++)
            indexes.add(new ArrayList<>());
        int mask = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int idx = c - 'a';
            mask = mask | (1 << idx);
            indexes.get(idx).add(i);
        }
        
        StringBuilder result = new StringBuilder();
        int prev = 0;
        while (mask != 0) {
            for (int i = 0; i < 26; i++) {
                if (((mask >> i) & 1) == 0) continue;
                int first = bs(indexes.get(i), prev);
                boolean flag = true;
                for (int j = 0; j < 26; j++) {
                    if (((mask >> j) & 1) == 0) continue;
                    if (indexes.get(j).get(indexes.get(j).size() - 1) < first) {
                        flag = false;
                        break;
                    }
                }
                
                if (!flag) continue;
                char c = (char) (i + 'a');
                result.append(c);
                mask = mask ^ (1 << i);
                prev = first;
                break;
            }
        }
        
        return result.toString();
    }
    
    private static int bs(List<Integer> list, int prev) {
        
        int l = 0, r = list.size() - 1;
        while (r - l > 1) {
            int mid = l + ((r - l) / 2);
            if (list.get(mid) >= prev)
                r = mid;
            else
                l = mid;
        }
        if (list.get(l) >= prev) return list.get(l);
        return list.get(r);
    }
}