class Solution {
    
    private static int[] arr;
    public int minCostSetTime(int s, int m, int p, int t) {
        arr = new int[4];
        
        int min = t / 60;
        int sec = t % 60;
        
        int min_temp = min, sec_temp = sec;
        if (min > 99) {
            min_temp--;
            sec_temp += 60;
        }
        util(min_temp, sec_temp);
        
        
        int cost1 = calc(s, m, p);
        int cost2 = (int) (2e9);
        
        if (sec < 40 && min > 0) {
            min_temp = min - 1;
            sec_temp = sec + 60;
            util(min_temp, sec_temp);
            cost2 = calc(s, m, p);
        }
        
        return Math.min(cost1, cost2);
    }
    
    private static void util(int min_temp, int sec_temp) {
        arr[1] = (min_temp % 10);
        min_temp /= 10;
        arr[0] = min_temp;
        
        arr[3] = (sec_temp % 10);
        sec_temp /= 10;
        arr[2] = sec_temp;
    }
    
    private static int calc(int prev, int m, int p) {
        
        int cost = 0;
        int i;
        for (i = 0; i < 4; i++)
            if (arr[i] > 0)
                break;
        
        for (; i < 4; i++) {
            cost += p;
            if (arr[i] == prev)
                continue;
            prev = arr[i];
            cost += m;
        }
        
        return cost;
    }
}