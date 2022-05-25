class Solution {
    public int maxEnvelopes(int[][] nums) {
        int n = nums.length;
        Comparator<int[]> myComp = (o1, o2) -> 
            (o1[0] == o2[0] ? (o2[1] - o1[1]) : (o1[0] - o2[0]));
        Arrays.sort(nums, myComp);
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (list.size() == 0 || list.get(list.size() - 1) < nums[i][1])
                list.add(nums[i][1]);
            else {
                int idx = bs(list, nums[i][1]);
                list.set(idx, nums[i][1]);
            }
        }
        return list.size();
    }
    
    private static int bs(List<Integer> list, int x) {
        int l = 0, r = list.size() - 1;
        while (r - l > 1) {
            int mid = l + ((r - l) / 2);
            if (list.get(mid) >= x)
                r = mid;
            else
                l = mid;
        }
        if (list.get(l) >= x) return l;
        return r;
    }
}