class MapSum {

    Map<String, Integer> map;
    private class Node {
        Node[] links;
        int currVal;
        Node() {
            links = new Node[26];
            currVal = 0;
        }
    }
    
    private Node root;
    public MapSum() {
        map = new HashMap<>();
        root = new Node();
    }
    
    public void insert(String key, int val) {
        int delta = val - map.getOrDefault(key, 0);
        map.put(key, val);
        Node curr = root;
        for (char c : key.toCharArray()) {
            int ascii = c - 'a';
            if (curr.links[ascii] == null) 
                curr.links[ascii] = new Node();
            curr = curr.links[ascii];
            curr.currVal += delta;
        }
    }
    
    public int sum(String prefix) {
        Node curr = root;
        for (char c : prefix.toCharArray()) {
            int ascii = c - 'a';
            if (curr.links[ascii] == null) return 0;
            curr = curr.links[ascii];
        }
        return curr.currVal;
    }
}

/**
 * Your MapSum object will be instantiated and called as such:
 * MapSum obj = new MapSum();
 * obj.insert(key,val);
 * int param_2 = obj.sum(prefix);
 */