class LRUCache {

    private static Map<Integer, Integer> map;
    private static Queue<Pair> qq;
    private static int[] updated_priority;
    private static int limit, counter;
    public LRUCache(int capacity) {
        
        map = new HashMap<>();
        qq = new LinkedList<>();
        updated_priority = new int[(int) (1e4 + 5)];
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
            util(key);
        } else {
            while (updated_priority[qq.peek().x] != qq.peek().y) qq.poll();
            Pair front = qq.poll();
            map.remove(front.x);
            util(key);
        }
        map.put(key, value);
    }
    
    private static void util(int key) {
        updated_priority[key] = counter;
        qq.offer(new Pair(key, counter));
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