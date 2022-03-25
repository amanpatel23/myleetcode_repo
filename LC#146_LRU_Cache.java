class LRUCache {

    private static Map<Integer, Integer> map;
    private static Queue<Pair> pq;
    private static int[] curr_priority;
    private static int limit, counter;
    public LRUCache(int capacity) {
        
        map = new HashMap<>();
        Comparator<Pair> myComp = (o1, o2) -> (o1.x - o2.x);
        pq = new PriorityQueue<>(myComp);
        curr_priority = new int[(int) (1e4 + 5)];
        limit = capacity;
        counter = 1;
    }
    
    public int get(int key) {
        
        if (map.containsKey(key)) {
            util(key);
            return map.get(key);
        }
        
        return -1;
    }
    
    public void put(int key, int value) {
        
        if (map.containsKey(key) || map.size() < limit) {
            map.put(key, value);
            util(key);
        } else {
            while (curr_priority[pq.peek().y] != pq.peek().x) pq.poll();
            Pair top = pq.poll();
            map.remove(top.y);
            map.put(key, value);
            util(key);
        }
    }
    
    private static void util(int key) {
        curr_priority[key] = counter;
        pq.add(new Pair(counter, key));
        counter++;
    }
    
    private static class Pair {
        int x, y;
        Pair (int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}


/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */