class Solution {
    public boolean increasingTriplet(int[] nums) {
        int ff = Integer.MAX_VALUE, ss = Integer.MAX_VALUE;
        for (int num : nums) {
            if (num <= ff) ff = num;
            else if (num <= ss) ss = num;
            else return true;
        }
        return false;
    }
}