class Solution {
    
    private static final int iMin = (int) (-1e9 - 100);
    public boolean find132pattern(int[] nums) {
        
        int n = nums.length;
        Stack<Integer> stack = new Stack<>();
        int max = iMin;
        for (int i = (n - 1); i >= 0; i--) {
            if (nums[i] < max) return true;
            while (!stack.isEmpty() && (nums[i] >= stack.peek())) {
                int top = stack.pop();
                if (top != nums[i]) max = Math.max(max, top);
            }
            stack.add(nums[i]);
        }
        return false;
    }
}