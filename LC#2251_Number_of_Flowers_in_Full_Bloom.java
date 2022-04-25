class Solution {
    public int[] fullBloomFlowers(int[][] flowers, int[] persons) {
        
        int n = flowers.length;
        List<Integer> inc_st_time = new ArrayList<>(), inc_end_time = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            inc_st_time.add(i);
            inc_end_time.add(i);
        }
        
        inc_st_time.sort(Comparator.comparingInt(x -> flowers[x][0]));
        inc_end_time.sort(Comparator.comparingInt(x -> flowers[x][1]));
        
        int len = persons.length;
        int[] result = new int[len];
        for (int i = 0; i < len; i++) {
            int x = persons[i];
            result[i] = bs1(inc_st_time, x, flowers) - bs2(inc_end_time, x, flowers);
        }
        
        return result;
    }
    
    private static int bs1(List<Integer> list, int x, int[][] flowers) {
        int l = 0, r = list.size() - 1;
        while (r - l > 1) {
            int mid = l + ((r - l) / 2);
            if (flowers[list.get(mid)][0] <= x)
                l = mid;
            else
                r = mid;
        }
        if (flowers[list.get(r)][0] <= x) return r + 1;
        else if (flowers[list.get(l)][0] <= x) return l + 1;
        else return 0;
    }
    
    private static int bs2(List<Integer> list, int x, int[][] flowers) {
        int l = 0, r = list.size() - 1;
        while (r - l > 1) {
            int mid = l + ((r - l) / 2);
            if (flowers[list.get(mid)][1] < x) 
                l = mid;
            else
                r = mid;
        }
        if (flowers[list.get(r)][1] < x) return r + 1;
        else if (flowers[list.get(l)][1] < x) return l + 1;
        return 0;
    }
}