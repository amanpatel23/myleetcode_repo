class Solution {

    public int minimumRefill(int[] plants, int capacityA, int capacityB) {

        int n = plants.length;
        int[] curr = new int[2];
        curr[0] = capacityA;
        curr[1] = capacityB;

        int result = 0;
        int i = 0, j = n - 1;
        while (i <= j) {
            if (i == j) {
                if (curr[1] > curr[0]) {
                    if (hadToRefill(plants[j], capacityB, curr, 1))
                        result++;
                } else {
                    if (hadToRefill(plants[i], capacityA, curr, 0))
                        result++;
                }
            } else {
                // Alice
                if (hadToRefill(plants[i], capacityA, curr, 0))
                    result++;

                // Bob
                if (hadToRefill(plants[j], capacityB, curr, 1))
                    result++;
            }

            i++;
            j--;
        }

        return result;
    }

    private static boolean hadToRefill(int req, int cap, int[] curr, int idx) {
        boolean result = false;
        if (curr[idx] < req) {
            result = true;
            curr[idx] = cap;
        }

        curr[idx] -= req;
        return result;
    }
}