class Solution {
    
    public int[] findOrder(int n, int[][] prerequisites) {
        
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < n; i++) adjList.add(new ArrayList<>());
        int[] indegrees = new int[n];
        for (int[] prereq : prerequisites) {
            int a = prereq[0], b = prereq[1];
            adjList.get(b).add(a);
            indegrees[a]++;
        }
        
        Queue<Integer> qq = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (indegrees[i] == 0) {
                qq.offer(i);
            }
        }
        
        int idx = 0;
        int[] result = new int[n];
        while (!qq.isEmpty()) {
            
            int front = qq.poll();
            result[idx++] = front;
            for (int x : adjList.get(front)) {
                indegrees[x]--;
                if (indegrees[x] == 0) qq.offer(x);
            }
        }
        
        if (idx != n) return new int[]{};
        return result;
    }
}