class Solution {
    public boolean haveConflict(String[] event1, String[] event2) {

        Set<Integer> set = new HashSet<>();
        int ff = util(event1[0]);
        int ss = util(event1[1]);
        for (int i = ff; i <= ss; i++) set.add(i);
        ff = util(event2[0]);
        ss = util(event2[1]);
        for (int i = ff; i <= ss; i++) {
            if (set.contains(i)) return true;
        }
        return false;
    }

    private int util(String str) {
        String[] arr = str.split(":");
        int hh = Integer.parseInt(arr[0]);
        int mm = Integer.parseInt(arr[1]);
        int ans = (hh * 60) + mm;
        return ans;
    }
}