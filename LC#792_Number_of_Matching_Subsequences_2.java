class Solution {
    public int numMatchingSubseq(String s, String[] words) {
        int n = s.length();
        List<List<Integer>> occu = new ArrayList<>();
        for (int i = 0; i < 26; i++) occu.add(new ArrayList<>());
        
        for (int i = 0; i < n; i++) occu.get(s.charAt(i) - 'a').add(i);
        
        int ans = 0;
        for (String str : words) {
            int prev = -1;
            boolean flag = true;
            for (char c : str.toCharArray()) {
                int idx = bs(occu.get(c - 'a'), prev);
                if (idx == -1) {
                    flag = false;
                    break;
                }
                prev = idx;
            }
            if (flag) ans++;
        }
        return ans;
    }
    
    private int bs(List<Integer> list, int x) {
        if (list.size() == 0) return -1;
        int l = 0, r = list.size() - 1;
        while (r - l > 1) {
            int mid = l + ((r - l) / 2);
            if (list.get(mid) <= x) l = mid;
            else r = mid;
        }
        if (list.get(l) > x) return list.get(l);
        if (list.get(r) > x) return list.get(r);
        return -1;
    }
}