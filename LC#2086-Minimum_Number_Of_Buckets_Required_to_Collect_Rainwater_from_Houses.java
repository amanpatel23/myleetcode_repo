class Solution {
    public int minimumBuckets(String street) {

        int n = street.length();
        int prevBucket = -2;
        int result = 0;
        for (int i = 0; i < n; i++) {
            if (street.charAt(i) == '.')
                continue;
            
            if (prevBucket == i - 1)
                continue;
            if (i + 1 < n && street.charAt(i + 1) == '.') {
                prevBucket = i + 1;
                result += 1;
                continue;
            }
            if (i - 1 >= 0 && street.charAt(i - 1) == '.') {
                prevBucket = i - 1;
                result += 1;
                continue;
            }
            
            return -1;
        }
        
        return result;
    }
}