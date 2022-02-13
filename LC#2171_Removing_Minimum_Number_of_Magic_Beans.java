class Solution {
    public long minimumRemoval(int[] beans) {

        List<Integer> list = new ArrayList<>();
        for (int bean : beans) {
            list.add(bean);
        }

        Collections.sort(list);

        int n = beans.length;
        long[] prefixSum = new long[n], suffixSum = new long[n];
        for (int i = 0; i < n; i++)
            prefixSum[i] = list.get(i) + ((i == 0) ? 0 : prefixSum[i - 1]);
        for (int i = (n - 1); i >= 0; i--)
            suffixSum[i] = list.get(i) + ((i == (n - 1)) ? 0 : suffixSum[i + 1]);
        
        int[] seen = new int[(int) (1e5) + 1];
        long result = (long) (1e16);
        for (int i = 0; i < n; i++) {
            int num = list.get(i);
            long right = (i < (n - 1)) ? suffixSum[i + 1] : 0;
            long left = ((i - seen[num]) > 0) ? prefixSum[i - 1 - seen[num]] : 0;
            
            long curr = right - ((long) (n - 1 - i) * num);
            curr += left;
            seen[num]++;
            result = Math.min(result, curr);
        }
        
        return result;
    }
}