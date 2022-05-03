class Solution {
    public int findUnsortedSubarray(int[] nums) {
        
        int n = nums.length;
        Stack<Integer> stack = new Stack<>();
        int l = (int) (1e5);
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] > nums[i])
                l = Math.min(l, stack.pop());
            stack.add(i);
        }
        stack = new Stack<>();
        int r = -1;
        for (int i = (n - 1); i >= 0; i--) {
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i])
                r = Math.max(r, stack.pop());
            stack.add(i);
        }
        
        return (r == -1 ? 0 : (r - l + 1));
    }
}