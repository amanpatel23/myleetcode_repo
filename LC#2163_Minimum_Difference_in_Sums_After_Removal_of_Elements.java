class Solution {
    public long minimumDifference(int[] nums) {
        
        int len = nums.length;
        int n = len / 3;
        
        Queue<Integer> pq1 = new PriorityQueue<Integer>((o1, o2) -> (o2 - o1));
        Queue<Integer> pq2 = new PriorityQueue<Integer>((o1, o2) -> (o1 - o2));
        
        long sum1 = 0, sum2 = 0;
        long[] arr = new long[len];
        for (int i = 0; i < (len - n); i++) {
            if (i < n) {
                pq1.offer(nums[i]);
                sum1 += nums[i];
            }else if (pq1.peek() > nums[i]) {
                sum1 -= pq1.poll();
                sum1 += nums[i];
                pq1.offer(nums[i]);
            }
            arr[i] = sum1;
        }
        
        long result = (long) (1e15);
        for (int i = (len - 1); (i - n) >= 0; i--) {
            if ((i + n) >= len) {
                pq2.offer(nums[i]);
                sum2 += nums[i];
            }else if(pq2.peek() < nums[i]) {
                sum2 -= pq2.poll();
                sum2 += nums[i];
                pq2.offer(nums[i]);
            }
            
            arr[i] = sum2;
            if ((i + n) <= len)
                result = Math.min(result, arr[i - 1] - arr[i]);
        }
        
        return result;
    }
}