class Solution {
    
    Map<Integer, List<Integer>> num_idx;
    public long[] getDistances(int[] arr) {
        
        int n = arr.length;
        
        num_idx = new HashMap<>();
        for (int i = 0; i < n; i++) {
            num_idx.putIfAbsent(arr[i], new ArrayList<>());
            num_idx.get(arr[i]).add(i);
        }
        
        long[] result = new long[n];
        for (Map.Entry<Integer, List<Integer>> x: num_idx.entrySet()) {
            //System.out.println(x.getKey() + " " + x.getValue());
            long right = 0, left = 0;
            long cnt1 = 0, cnt2 = 0;
            for (int idx: x.getValue()) {
                right += idx;
                cnt1++;
            }
            //System.out.println(right);
            for (int idx: x.getValue()) {
                right -= idx;
                cnt1--;
                result[idx] = ((idx * cnt2) - (idx * cnt1)) + right - left;
                //System.out.println("right: " + right + " left: " + left);
                left += idx;
                cnt2++;
            }
        }
        
        return result;
    }
}