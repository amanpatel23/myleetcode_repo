class Bitset {

    private static int n;
    private static int[] arr, record;
    private static int no_of_flips;
    private static int no_of_ones;

    public Bitset(int size) {
        n = size;
        arr = new int[n];
        record = new int[n];
        no_of_flips = 0;
        no_of_ones = 0;
    }

    public void fix(int idx) {
        int temp = no_of_flips - record[idx];
        if ((temp & 1) == 1) {
            arr[idx] ^= 1;
        }
        record[idx] = no_of_flips;

        if (arr[idx] == 0)
            no_of_ones++;
        arr[idx] = 1;
    }

    public void unfix(int idx) {
        int temp = no_of_flips - record[idx];
        if ((temp & 1) == 1) {
            arr[idx] ^= 1;
        }
        record[idx] = no_of_flips;

        if (arr[idx] == 1)
            no_of_ones--;
        arr[idx] = 0;
    }

    public void flip() {
        no_of_flips++;
        no_of_ones = n - no_of_ones;
    }

    public boolean all() {
        return (no_of_ones == n);
    }

    public boolean one() {
        return (no_of_ones > 0);
    }

    public int count() {
        return no_of_ones;
    }

    public String toString() {
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int temp = no_of_flips - record[i];
            if ((temp & 1) == 1) {
                arr[i] ^= 1;
            }
            record[i] = no_of_flips;

            str.append(arr[i]);
        }
        return str.toString();
    }
}

/**
 * Your Bitset object will be instantiated and called as such:
 * Bitset obj = new Bitset(size);
 * obj.fix(idx);
 * obj.unfix(idx);
 * obj.flip();
 * boolean param_4 = obj.all();
 * boolean param_5 = obj.one();
 * int param_6 = obj.count();
 * String param_7 = obj.toString();
 */