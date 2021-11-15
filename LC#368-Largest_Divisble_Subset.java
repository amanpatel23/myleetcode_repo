class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        
        Arrays.sort(nums);
        int n = nums.length;
        List<ArrayList<Integer>> result = new ArrayList<>();
        for (int i = 0; i < n; i++)
            result.add(new ArrayList());
        for (int i = 0; i < n; i++)
            result.get(i).add(nums[i]);
        
        for (int i = 0; i < n; i++) {
            int idx = -1;
            int len = 0;
            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] % nums[j] == 0) {
                    if (result.get(j).size() > len) {
                        idx = j;
                        len = result.get(j).size();
                    }
                }
            }
            if (idx >= 0) {
                result.get(i).addAll(result.get(idx));
            }
        }
        
        int idx = 0;
        int len = 1;
        for (int i = 0; i < n; i++) {
            if (result.get(i).size() > len) {
                idx = i;
                len = result.get(i).size();
            }
        }
        
        return result.get(idx);
    }
}