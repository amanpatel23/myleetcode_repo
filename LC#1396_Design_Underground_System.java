class UndergroundSystem {

    private static Map<Integer, Pair<String, Integer>> checkInMap;
    private static Map<Pair<String, String>, int[]> checkOutMap;
    public UndergroundSystem() {
        checkInMap = new HashMap<>();
        checkOutMap = new HashMap<>();
    }
    
    public void checkIn(int id, String stationName, int t) {
        checkInMap.put(id, new Pair<>(stationName, t));
    }
    
    public void checkOut(int id, String stationName, int t) {
        String stStation = checkInMap.get(id).first;
        int t1 = checkInMap.get(id).second;
        Pair<String, String> pp = new Pair<>(stStation, stationName);
        if (!checkOutMap.containsKey(pp)) checkOutMap.put(pp, new int[]{0, 0});
        checkOutMap.get(pp)[0] += (t - t1);
        checkOutMap.get(pp)[1]++;
    }
    
    public double getAverageTime(String startStation, String endStation) {
        Pair<String, String> pp = new Pair<>(startStation, endStation);
        double ans = (1.0 * checkOutMap.get(pp)[0]) / checkOutMap.get(pp)[1];
        return ans;
    }
    
    private static class Pair<U, V> {

        private final U first;
        private final V second;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair<?, ?> pair = (Pair<?, ?>) o;
            return first.equals(pair.first) && second.equals(pair.second);
        }

        @Override
        public int hashCode() {
            return Objects.hash(first, second);
        }

        @Override
        public String toString() {
            return "(" + first + ", " + second + ")";
        }

        private Pair(U ff, V ss) {
            this.first = ff;
            this.second = ss;
        }
    }
}

/**
 * Your UndergroundSystem object will be instantiated and called as such:
 * UndergroundSystem obj = new UndergroundSystem();
 * obj.checkIn(id,stationName,t);
 * obj.checkOut(id,stationName,t);
 * double param_3 = obj.getAverageTime(startStation,endStation);
 */