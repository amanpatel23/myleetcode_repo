class Solution {
    
    private static final int iMax = (int) (1e9);
    public int minDominoRotations(int[] tops, int[] bottoms) {
        
        int n = tops.length;
        int result = iMax;
        for (int num = 1; num <= 6; num++) {
            int cnt1 = 0, cnt2 = 0;
            boolean flag = true;
            for (int i = 0; i < n; i++) {
                if (tops[i] != num && bottoms[i] != num) {
                    flag = false;
                    break;
                }
                if (tops[i] == num && bottoms[i] == num) continue;
                
                if (tops[i] == num) cnt1++;
                else cnt2++;
            }
            
            if (flag) result = Math.min(result, Math.min(cnt1, cnt2));
        }
        
        return (result == iMax) ? -1 : result;
    }
}