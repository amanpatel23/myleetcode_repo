class TimeMap {

    private static Map<String, List<Integer>> map1;
    private static Map<String, List<String>> map2;
    public TimeMap() {
        
        map1 = new HashMap<>();
        map2 = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if (!map1.containsKey(key)) {
            map1.put(key, new ArrayList<>());
            map2.put(key, new ArrayList<>());
        }
        map1.get(key).add(timestamp);
        map2.get(key).add(value);
    }
    
    public String get(String key, int timestamp) {
        if (!map1.containsKey(key)) return "";
        else {
            int idx = bs(timestamp, map1.get(key));
            if (idx == -1) return "";
            return map2.get(key).get(idx);
        }
    }
    
    private static int bs(int x, List<Integer> list) {
        int l = 0, r = list.size() - 1;
        while (r - l > 1) {
            int mid = l + ((r - l) / 2);
            if (list.get(mid) <= x) l = mid;
            else r = mid;
        }
        if (list.get(r) <= x) return r;
        else if (list.get(l) <= x) return l;
        return -1;
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */