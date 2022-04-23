class Solution {
    public int minimumTime(int n, int[][] relations, int[] time) {
        
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < n; i++) adjList.add(new ArrayList<>());
        int[] inorder = new int[n];
        for (int[] arr : relations) {
            inorder[arr[1] - 1]++;
            adjList.get(arr[0] - 1).add(arr[1] - 1);
        }
        int[] start_time = new int[n];
        Queue<int[]> qq = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (inorder[i] == 0) qq.offer(new int[]{i, 0});
        }
        int ans = 0;
        while (!qq.isEmpty()) {
            int[] front = qq.poll();
            int finish_time = front[1] + time[front[0]];
            ans = Math.max(ans, finish_time);
            for (int x : adjList.get(front[0])) {
                start_time[x] = Math.max(start_time[x], finish_time);
                if (--inorder[x] == 0) qq.offer(new int[]{x, start_time[x]});
            }
        }
        
        return ans;
    }
}