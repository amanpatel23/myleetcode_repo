class Solution {
    public int minGroups(int[][] intervals) {

        int n = intervals.length;
        int[] prefix_sum = new int[(int) (1e6) + 5];
        for (int[] arr : intervals) {
            prefix_sum[arr[0]]++;
            prefix_sum[arr[1] + 1]--;
        }
        int ans = 0;
        for (int i = 1; i <= (int) (1e6); i++) {
            prefix_sum[i] += prefix_sum[i - 1];
            ans = Math.max(ans, prefix_sum[i]);
        }
        return ans;
    }
}