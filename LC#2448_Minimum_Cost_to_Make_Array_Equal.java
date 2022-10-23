class Solution {
    public long minCost(int[] nums, int[] cost) {

        int n = nums.length;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) list.add(i);
        list.sort(Comparator.comparingInt(idx -> nums[idx]));

        long[] prefix_ff = new long[n];
        long[] prefix_ss = new long[n];
        for (int i = 0; i < n; i++) {
            int idx = list.get(i);
            int num = nums[idx];
            int amnt = cost[idx];
            prefix_ff[i] = (long) num * amnt;
            prefix_ss[i] = amnt;
            if (i > 0) {
                prefix_ff[i] += prefix_ff[i - 1];
                prefix_ss[i] += prefix_ss[i - 1];
            }
        }

        long ans = Long.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int num = nums[list.get(i)];
            long curr = prefix_ff[n - 1];
            curr -= prefix_ff[i];
            curr -= ((long) num * (prefix_ss[n - 1] - prefix_ss[i]));
            if (i > 0) {
                curr -= prefix_ff[i - 1];
                curr += ((long) num * prefix_ss[i - 1]);
            }
            ans = Math.min(ans, curr);
        }
        return ans;
    }
}