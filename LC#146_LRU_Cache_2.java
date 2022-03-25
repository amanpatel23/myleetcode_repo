class LRUCache {

    private static Map<Integer, Pair> map;
    private static Queue<Pair> qq;
    private static int limit, counter;
    public LRUCache(int capacity) {
        
        map = new HashMap<>();
        qq = new LinkedList<>();
        limit = capacity;
        counter = 1;
    }
    
    public int get(int key) {
        if (map.containsKey(key)) {
            util(key, map.get(key).x);
            return map.get(key).x;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if (!map.containsKey(key) && map.size() >= limit) {
            while (map.get(qq.peek().x).y != qq.peek().y) qq.poll();
            Pair front = qq.poll();
            map.remove(front.x);
        }
        util(key, value);
    }
    
    private static void util(int key, int value) {
        qq.offer(new Pair(key, counter));
        map.put(key, new Pair(value, counter));
        counter++;
    }
    
    private static class Pair {
        int x, y;
        Pair(int x, int y) {
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