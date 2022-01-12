class Solution {
    public int earliestFullBloom(int[] plantTime, int[] growTime) {

        int n = plantTime.length;
        List<Pair<Integer, Integer>> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(new Pair<>(plantTime[i], growTime[i]));
        }

        Comparator<Pair<Integer, Integer>> myComp = (o1, o2) -> (o2.second - o1.second);
        list.sort(myComp);
        int curr = -1;
        int result = (int) (-1e9);
        for (int i = 0; i < n; i++) {
            curr += list.get(i).first;
            result = Math.max(result, curr + list.get(i).second + 1);
        }
        
        return result;
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