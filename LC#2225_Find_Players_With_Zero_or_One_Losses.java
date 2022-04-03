class Solution {
    public List<List<Integer>> findWinners(int[][] matches) {
        
        int[] players = new int[(int) (1e5) + 1];
        Arrays.fill(players, -1);
        
        for (int[]  match : matches) {
            int w = match[0], l = match[1];
            if (players[w] == -1) players[w] = 0;
            if (players[l] == -1) players[l] = 0;
            players[l]++;
        }
        
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> ff = new ArrayList<>(), ss = new ArrayList<>();
        for (int i = 1; i <= (int) (1e5); i++) {
            if (players[i] == -1) continue;
            if (players[i] == 0) ff.add(i);
            if (players[i] == 1) ss.add(i);
        }
        result.add(ff);
        result.add(ss);
        
        return result;
    }
}