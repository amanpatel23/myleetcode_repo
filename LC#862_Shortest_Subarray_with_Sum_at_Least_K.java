class Solution {
    public int shortestSubarray(int[] nums, int k) {
        int n = nums.length;
        long[] prefix_sum = new long[n + 1];
        for (int i = 0; i < n; i++) prefix_sum[i + 1] = prefix_sum[i] + nums[i];
        Deque<Integer> dq = new ArrayDeque<Integer>();
        int ans = n + 1;
        for (int i = 0; i <= n; i++) {
            while (!dq.isEmpty() && prefix_sum[i] - prefix_sum[dq.getFirst()] >= k) 
                ans = Math.min(ans, i - dq.pollFirst());
            while (!dq.isEmpty() && prefix_sum[i] <= prefix_sum[dq.getLast()])
                dq.removeLast();
            dq.addLast(i);
        }
        return (ans > n ? -1 : ans);
    }
}