class Solution {
    public int totalSteps(int[] nums) {
        Stack<int[]> stack = new Stack<>();
        int ans = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            int cnt = 0;
            while (!stack.isEmpty() && stack.peek()[0] < nums[i]) {
                cnt = Math.max(cnt + 1, stack.pop()[1]);
            }
            ans = Math.max(ans, cnt);
            stack.add(new int[]{nums[i], cnt});
        }
        return ans;
    }
}