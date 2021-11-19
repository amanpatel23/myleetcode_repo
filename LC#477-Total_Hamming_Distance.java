class Solution {
    public int totalHammingDistance(int[] nums) {
        
        int result = 0;
        for (int i = 0; i < 32; i++) {
            int ones = 0, zeroes = 0;
            for (int num: nums) {
                if (getBit(num, i) == 1)
                    ones += 1;
                else
                    zeroes += 1;
            }
            result += (ones * zeroes);
        }
        
        return result;
    }
    
    private static int getBit(int num, int i) {
        return ((num & (1 << i)) != 0 ? 1 : 0);
    }
}