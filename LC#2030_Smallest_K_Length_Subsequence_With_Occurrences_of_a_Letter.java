class Solution {
    
    public String smallestSubsequence(String s, int k, char l, int r) {
        
        List<List<Integer>> indexes = new ArrayList<>();
        for (int i = 0; i < 26; i++) indexes.add(new ArrayList<>());
        
        int n = s.length();
        int mask = 0;
        int[] l_freq = new int[n];
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            int idx = c - 'a';
            indexes.get(idx).add(i);
            mask |= (1 << idx);
            l_freq[i] = (i == 0 ? 0 : l_freq[i - 1]) + (c == l ? 1 : 0);
        }
        
        StringBuilder result = new StringBuilder();
        int prev = -1;
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < 26; j++) {
                if (((mask >> j) & 1) == 0) continue;
                char c = (char) ('a' + j);
                int next = bs(indexes.get(j), prev);
                //System.out.println(i + " " + c + " " + prev + " " + next);
                if (next > prev && (k - i) <= (n - next)) {
                    if (r == 0) {
                        result.append(c);
                        prev = next;
                        break;
                    }
                    else if (c == l) {
                        result.append(c);
                        r--;
                        prev = next;
                        break;
                    }else if (l_freq[n - 1] - l_freq[next] >= r && (k - i - 1) >= r) {
                        result.append(c);
                        prev = next;
                        break;
                    }
                }
            }
        }
        
        return result.toString();
    }
    
    private static int bs(List<Integer> list, int prev) {
        
        int l = 0, r = list.size() - 1;
        while (r - l > 1) {
            int mid = (l + ((r - l) / 2));
            if (list.get(mid) > prev)
                r = mid;
            else
                l = mid;
        }
        
        if (list.get(l) > prev) return list.get(l);
        return list.get(r);
    }
}