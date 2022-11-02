class Solution {
    public int minMutation(String start, String end, String[] bank) {
        
        int n = bank.length;
        Queue<int[]> qq = new LinkedList<>();
        qq.add(new int[]{-1, 0});
        while (!qq.isEmpty()) {
            int[] front = qq.poll();
            String prev = front[0] == -1 ? start : bank[front[0]];
            if (prev.equals(end)) return noOfSetBits(front[1]);
            int mask = front[1];
            if (mask == (1 << n) - 1) continue;
            for (int i = 0; i < n; i++) {
                if (((mask >> i) & 1) == 1) continue;
                int cnt = 0;
                for (int ii = 0; ii < 8; ii++) {
                    if (prev.charAt(ii) != bank[i].charAt(ii)) cnt++;
                }
                if (cnt == 1) qq.add(new int[]{i, mask | (1 << i)});
            }
        }
        return -1;
    }
    
    private static int noOfSetBits(long x) {
        int cnt = 0;
        while (x != 0) {
            x = x & (x - 1);
            cnt++;
        }
        return cnt;
    }
}