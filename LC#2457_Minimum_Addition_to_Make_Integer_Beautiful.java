class Solution {
    public long makeIntegerBeautiful(long n, int target) {
        int dd = noOfDigits(n);
        int[] arr = new int[dd + 1];
        long xx = n;
        int sum = 0;
        for (int i = dd; i >= 1; i--) {
            int lastDigit = (int) (xx % 10);
            arr[i] = lastDigit;
            sum += lastDigit;
            xx /= 10;
        }
        if (sum <= target) return 0;
        for (int i = 1; i <= dd; i++) {
            if (arr[dd - i] == 9) continue;
            int[] temp = arr.clone();
            int ii = i, idx = dd;
            while (ii-- > 0) temp[idx--] = 0;
            temp[dd - i]++;
            sum = 0;
            for (int jj = 0; jj <= dd; jj++) sum += temp[jj];
            if (sum <= target) {
                long z = 0;
                for (int jj = 0; jj <= dd; jj++) z = (z * 10) + temp[jj];
                long ans = z - n;
                return ans;
            }
        }
        return -1;
    }
    
    private static int noOfDigits(long num) {
        int cnt = 0;
        while (num > 0) {
            cnt++;
            num /= 10;
        }
        return cnt;
    }
}