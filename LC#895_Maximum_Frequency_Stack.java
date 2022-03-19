class FreqStack {

        private static Map<Integer, Integer> map;
        private static Queue<Triplet> pq;
        private static int counter;
        public FreqStack() {

            map = new HashMap<>();
            Comparator<Triplet> myComp = (o1, o2) -> ((o1.b == o2.b) ? 
                                                      (o2.c - o1.c) : (o2.b - o1.b));
            pq = new PriorityQueue<>(myComp);
            counter = 1;
        }

        public void push(int val) {

            map.put(val, map.getOrDefault(val, 0) + 1);
            pq.add(new Triplet(val, map.get(val), counter));
            counter++;
        }

        public int pop() {

            Triplet top = pq.poll();
            map.put(top.a, map.get(top.a) - 1);
            return top.a;
        }

        private static class Triplet {
            int a, b, c;
            Triplet(int a, int b, int c) {
                this.a = a;
                this.b = b;
                this.c = c;
            }
        }
    }

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */