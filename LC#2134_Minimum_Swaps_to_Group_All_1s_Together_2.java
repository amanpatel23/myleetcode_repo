class Solution {
    public int minSwaps(int[] nums) {

        int n = nums.length;
        int no_of_ones = 0;
        for (int x : nums) {
            if (x == 1)
                no_of_ones++;
        }

        int initial_zeroes = 0;
        for (int i = 0; i < no_of_ones; i++) {
            if (nums[i] == 0)
                initial_zeroes++;
        }

        int result = initial_zeroes;
        int curr_zeroes = initial_zeroes;
        int i = 1, j = no_of_ones;
        while (j < n) {
            if (nums[i - 1] == 0)
                curr_zeroes--;
            if (nums[j] == 0)
                curr_zeroes++;

            result = Math.min(result, curr_zeroes);
            i++;
            j++;
        }

        curr_zeroes = initial_zeroes;
        j = no_of_ones - 2;
        i = n - 1;
        while (j >= 0) {
            if (nums[j + 1] == 0)
                curr_zeroes--;
            if (nums[i] == 0)
                curr_zeroes++;
            
            result = Math.min(result, curr_zeroes);
            j--;
            i--;
        }
        
        return result;
    }
}