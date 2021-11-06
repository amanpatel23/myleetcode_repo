class Solution {
    public int[] singleNumber(int[] nums) {
        
        int[] result = new int[2];
        int a_xor_b = 0;
        for (int num: nums)
            a_xor_b ^= num;
        
        int rightmostSetBit = -1;
        for (int i = 0; i <= 32; i++) {
            if ((a_xor_b & (1 << i)) != 0) {
                rightmostSetBit = i;
                break;
            }
        }
        
        int a = 0;
        for (int num: nums) {
            if ((num & (1 << rightmostSetBit)) != 0)
                a ^= num;
        }
        
        int b = a_xor_b ^ a;
        
        result[0] = a;
        result[1] = b;
        return result;
    }
}