class Solution {
    public int numMatchingSubseq(String s, String[] words) {
        Map<Integer, List<int[]>> map = new HashMap<>();
        for (int i = 0; i < 26; i++) map.put(i, new ArrayList<>());
        
        int n = words.length;
        for (int i = 0; i < n; i++) {
            String str = words[i];
            int ascii = str.charAt(0) - 'a';
            map.get(ascii).add(new int[]{i, 0});
        }
        
        int ans = 0;
        for (char c : s.toCharArray()) {
            int ascii = c - 'a';
            List<int[]> temp = new ArrayList<>();
            for (int[] x : map.get(ascii)) {
                if (words[x[0]].length() == x[1] + 1) {
                    ans++;
                    continue;
                }
                int next = words[x[0]].charAt(x[1] + 1) - 'a';
                if (next == ascii) temp.add(new int[]{x[0], x[1] + 1});
                else map.get(next).add(new int[]{x[0], x[1] + 1});
            }
            map.put(ascii, temp);
        }
        
        return ans;
    }
}