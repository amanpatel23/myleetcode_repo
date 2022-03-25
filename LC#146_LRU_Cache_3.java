

class LRUCache {

    private static Node head, tail;
    private static Map<Integer, Node> map;
    private static int limit;
    public LRUCache(int capacity) {
        
        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        head.next = tail;
        tail.prev = head;
        map = new HashMap<>();
        limit = capacity;
    }
    
    public int get(int key) {
        
        if (map.containsKey(key)) {
            Node add = map.get(key);
            removeNode(add);
            addNode(add);
            return add.value;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node add = map.get(key);
            removeNode(add);
            Node node_new = new Node(key, value);
            addNode(node_new);
            map.put(key, node_new);
        } else if (map.size() < limit) {
            Node node_new = new Node(key, value);
            addNode(node_new);
            map.put(key, node_new);
        } else {
            Node node_to_be_removed = head.next;
            removeNode(node_to_be_removed);
            map.remove(node_to_be_removed.key);
            Node node_new = new Node(key, value);
            addNode(node_new);
            map.put(key, node_new);
        }
    }
    
    private static void removeNode(Node add) {
        add.prev.next = add.next;
        add.next.prev = add.prev;
        add.next = null;
        add.prev = null;
    }
    
    private static void addNode(Node add) {
        Node second_last_node = tail.prev;
        second_last_node.next = add;
        add.prev = second_last_node;
        add.next = tail;
        tail.prev = add;
    }
    
    private static class Node {
        int key, value;
        Node prev, next;
        Node (int key, int value) {
            this.key = key;
            this.value = value;
            this.prev = null;
            this.next = null;
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */