class Solution {
    public int smallestValue(int n) {
        
        int curr = helper(n);
        if (curr == n) return curr;
        else return smallestValue(curr);
    }
    
    private int helper(int n) {
        int sum = 0;
        while ((n & 1) == 0) {
            n /= 2;
            sum += 2;
        }
        for (int i = 3; i * i <= n; i++) {
            while ((n % i) == 0) {
                n /= i;
                sum += i;
            }
        }
        if (n >= 3) sum += n;
        return sum;
    }
}