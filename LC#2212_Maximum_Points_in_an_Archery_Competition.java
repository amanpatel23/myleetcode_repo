class Solution {
    public int[] maximumBobPoints(int numArrows, int[] aliceArrows) {

        int max_win = 0, max_win_mask = 0;
        for (int i = 0; i < (1 << 12); i++) {
            int curr_win = 0;
            int x = numArrows;
            for (int bit = 0; bit < 12; bit++) {
                if (((i >> bit) & 1) == 0) continue;
                x -= (aliceArrows[bit] + 1);
                if (x < 0) {
                    curr_win = (int) (-1e9);
                    break;
                }
                curr_win += bit;
            }

            if (curr_win > max_win) {
                max_win = curr_win;
                max_win_mask = i;
            }
        }
        //System.out.println(max_win + " " + max_win_mask);

        int[] result = new int[12];
        int left = numArrows;
        for (int bit = 0; bit < 12; bit++) {
            if (((max_win_mask >> bit) & 1) == 0) continue;
            result[bit] = (aliceArrows[bit] + 1);
            left -= result[bit];
        }
        result[0] += left;
        return result;
    }
}