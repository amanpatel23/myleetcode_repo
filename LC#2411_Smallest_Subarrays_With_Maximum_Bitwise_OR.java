class Solution {
    public int[] smallestSubarrays(int[] nums) {

        int n = nums.length;
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i <= 35; i++) {
            list.add(new ArrayList<>());
        }
        for (int i = 0; i < n; i++) {
            int num = nums[i];
            for (int bit = 0; bit < 32; bit++) {
                if (((num >> bit) & 1) == 1) {
                    list.get(bit).add(i);
                }
            }
        }
        
        int[] suffix_or = new int[n + 1];
        for (int i = n - 1; i >= 0; i--) {
            suffix_or[i] = suffix_or[i + 1] | nums[i];
        }
        //System.out.println(Arrays.toString(suffix_or));
        
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            int curr_or = suffix_or[i];
            List<Integer> temp = new ArrayList<>();
            int max = i;
            for (int bit = 0; bit < 32; bit++) {
                if (((curr_or >> bit) & 1) == 1) temp.add(bit);
            }
            //System.out.println(temp);
            for (int xx : temp) max = Math.max(max, bs(list.get(xx), i));
            ans[i] = max - i + 1;
        }
        
        return ans;
    }
    
    private static int bs(List<Integer> temp, int idx) {
        int l = 0, r = temp.size() - 1;
        while (r - l > 1) {
            int mid = l + ((r - l) / 2);
            if (temp.get(mid) >= idx) r = mid;
            else l = mid;
        }
        if (temp.get(l) >= idx) return temp.get(l);
        return temp.get(r);
    }
}