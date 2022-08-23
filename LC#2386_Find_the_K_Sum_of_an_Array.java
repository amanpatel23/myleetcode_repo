class Solution {
    public long kSum(int[] nums, int k) {
        
        int n = nums.length;
        long sum = 0;
        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            sum += Math.max(0, num);
            list.add(Math.abs(num));
        }
        Collections.sort(l  ist);
        Queue<long[]> pq = new PriorityQueue<>(Comparator.comparingLong(x -> x[0]));
        pq.add(new long[]{list.get(0), 0});
        long to_substract = 0;
        while (--k > 0) {
            long[] top = pq.poll();
            to_substract = top[0];
            int idx = (int) top[1];
            if (idx + 1 < n) {
                pq.add(new long[]{to_substract + list.get(idx + 1), idx + 1});
                pq.add(new long[]{to_substract - list.get(idx) + list.get(idx + 1), 
                                  idx + 1});
            }
        }
        sum -= to_substract;
        return sum;
    }
}