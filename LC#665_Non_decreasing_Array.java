class Solution {
    public boolean checkPossibility(int[] nums) {
        
        int n = nums.length;
        int ii = 0, jj = n - 1;
        while (ii + 1 < n && nums[ii + 1] >= nums[ii]) ii++;
        while (jj - 1 >= 0 && nums[jj - 1] <= nums[jj]) jj--;
        if (jj <= ii) return true;
        if (jj - ii > 1) return false;
        
        if (ii == 0 || jj == n - 1) return true; 
        if (nums[ii - 1] <= nums[jj]) return true;
        if (nums[jj + 1] >= nums[ii]) return true;
        
        return false;
    }
}