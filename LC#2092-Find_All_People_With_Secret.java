class Solution {
    
    private static final int iMax = (int) (1e9);
    private static List<ArrayList<Pair>> adjList;
    private static int[] knows;
    public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {
        
        adjList = new ArrayList<>();
        for (int i = 0; i < n; i++)
            adjList.add(new ArrayList());
        
        for (int[] x: meetings) 
            addEdge(x[0], x[1], x[2]);
        
        knows = new int[n];
        Arrays.fill(knows, iMax);
        knows[0] = 0; knows[firstPerson] = 0;
        
        Comparator<Pair> _comp = (Comparator.comparingInt(o -> o.x));
        Queue<Pair> pq = new PriorityQueue<>(_comp);
        
        pq.add(new Pair(0, 0)); pq.add(new Pair(0, firstPerson));
        
        while (!pq.isEmpty()) {
            
            Pair top = pq.poll();
            if (knows[top.y] < top.x)
                continue;
            
            for (Pair _pair: adjList.get(top.y)) {
                if (knows[_pair.x] > _pair.y && top.x <= _pair.y) {
                    knows[_pair.x] = _pair.y;
                    pq.add(new Pair(_pair.y, _pair.x));
                }
            }
        }
        
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (knows[i] != iMax) {
                result.add(i);
            }
        }
        
        return result;
    }
    
    private static void addEdge(int a, int b, int c) {
        adjList.get(a).add(new Pair(b, c));
        adjList.get(b).add(new Pair(a, c));
    }
    
    private static class Pair {
        int x, y;
        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}