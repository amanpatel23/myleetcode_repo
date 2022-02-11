class Solution {
    public int findNumberOfLIS(int[] nums) {
        
        int n = nums.length;
        int[] arr1 = new int[n], arr2 = new int[n];
        Arrays.fill(arr1, 1);
        Arrays.fill(arr2, 1);
        
        for (int i = 0; i < n; i++) {
            int max = (int) (-1e9);
            int cnt = 0;
            for (int j = 0; j < i; j++) {
                if (nums[j] >= nums[i])
                    continue;
                if (arr1[j] == max)
                    cnt += arr2[j];
                else if (arr1[j] > max) {
                    max = arr1[j];
                    cnt = arr2[j];
                }
            }
            
            if (cnt > 0) {
                arr1[i] = max + 1;
                arr2[i] = cnt;
            }
        }
        
        int global_max = arr1[0];
        int result = arr2[0];
        for (int i = 1; i < n; i++) {
            if (arr1[i] > global_max) {
                global_max = arr1[i];
                result = arr2[i];
            }else if (arr1[i] == global_max) {
                result += arr2[i];
            }
        }
        
        return result;
    }
}