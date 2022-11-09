class StockSpanner {

    private Stack<int[]> st;
    public StockSpanner() {
        st = new Stack<>();
    }
    
    public int next(int price) {
        int cnt = 1;
        while (!st.isEmpty() && st.peek()[0] <= price) {
            int[] top = st.pop();
            cnt += top[1];
        }
        st.add(new int[]{price, cnt});
        return cnt;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */