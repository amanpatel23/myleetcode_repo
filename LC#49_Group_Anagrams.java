class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        
        int n = strs.length;
        List<String> llFirst = new ArrayList<>();
        for (String str : strs) {
            char[] ccArr = str.toCharArray();
            Arrays.sort(ccArr);
            String modStr = String.valueOf(ccArr);
            llFirst.add(modStr);
        }
        List<Integer> llSecond = new ArrayList<>();
        for (int i = 0; i < n; i++) llSecond.add(i);
        llSecond.sort((i, j) -> llFirst.get(i).compareTo(llFirst.get(j)));
        
        List<List<String>> ans = new ArrayList<>();
        List<String> curr = new ArrayList<>();
        String prev = "#";
        for (int ii : llSecond) {
            if (prev.equals("#") || llFirst.get(ii).equals(prev)) {
                curr.add(strs[ii]);
                prev = llFirst.get(ii);
            }
            else {
                ans.add(curr);
                curr = new ArrayList<>(List.of(strs[ii]));
                prev = llFirst.get(ii);
            }
        }
        if (curr.size() != 0) ans.add(curr);
        
        return ans;
    }
}