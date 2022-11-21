class Solution {
    public long minimumFuelCost(int[][] roads, int seats) {
        int edges = roads.length;
        List<List<Integer>> adjList = new ArrayList<>();
        int[] inorder = new int[edges + 1];
        for (int i = 0; i <= edges; i++) adjList.add(new ArrayList<>());
        for (int[] arr : roads) {
            int a = arr[0], b = arr[1];
            inorder[a]++; inorder[b]++;
            adjList.get(a).add(b);
            adjList.get(b).add(a);
        }
        
        long ans = 0;
        Queue<long[]> qq = new LinkedList<>();
        long[] people = new long[edges + 1];
        Arrays.fill(people, 1);
        for (int i = 0; i <= edges; i++) {
            if (i != 0 && inorder[i] == 1) qq.add(new long[]{i, 1});
        }
        while (!qq.isEmpty()) {
            int size = qq.size();
            while (size-- > 0) {
                long[] front = qq.poll();
                int node = (int) front[0];
                long cc = front[1];
                ans += cc;
                for (int x : adjList.get(node)) {
                    people[x] += people[node];
                    if (--inorder[x] == 1 && x != 0) {
                        long cars = (people[x] + seats - 1) / seats;
                        qq.add(new long[]{x, cars});
                    }
                }
            }
        }
        return ans;
    }
}