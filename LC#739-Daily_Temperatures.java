class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        
        int n = temperatures.length;
        int[] answer = new int[n];
        Comparator<Pair> myComp = Comparator.comparingInt(o -> o.x);
        Queue<Pair> pq = new PriorityQueue<>(myComp);
        for (int i = 0; i < n; i++) {
            while (!pq.isEmpty() && (pq.peek().x < temperatures[i])) {
                Pair top = pq.poll();
                answer[top.y] = i - top.y;
            }
            pq.add(new Pair(temperatures[i], i));
        }
        
        return answer;
    }
    
    private static class Pair {
        int x, y;
        Pair(int _x, int _y) {
            this.x = _x;
            this.y = _y;
        }
    }
}