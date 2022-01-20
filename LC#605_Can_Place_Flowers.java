class Solution {
    
    private static int len;
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        
        len = flowerbed.length;
        if (len == 1) {
            if (flowerbed[0] == 1)
                return (n == 0);
            else
                return (n <= 1);
        }
        
        int i = -1;
        int no_of_zero = 0;
        int result = 0;
        
        for (int j = 0; j < len; j++) {
            if (flowerbed[j] == 0) {
                no_of_zero++;
                continue;
            }
            
            result += calc(i, j, no_of_zero);
            i = j;
            no_of_zero = 0;
        }
        
        result += calc(i, len, no_of_zero);
        return (result >= n);
    }
    
    private static int calc(int i, int j, int no_of_zero) {
        int count = 0;
        if (i == -1 && j == len) {
            count += ((no_of_zero + 1) / 2);
        }else if (i == -1 || j == len) {
            count += (no_of_zero / 2);
        }else if (no_of_zero >= 3) {
            count++;
            count += ((no_of_zero - 3) / 2);
        }
        
        //System.out.println(count);
        return count;
    }
}