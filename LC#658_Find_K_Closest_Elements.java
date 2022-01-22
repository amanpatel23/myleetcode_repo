class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        
        int n = arr.length;
        int l = 0, r = k - 1;
        for (int i = k; i < n; i++) {
            if (Math.abs(x - arr[i]) < Math.abs(x - arr[l]) || arr[l] == arr[i]) {
                l++;
                r++;
                continue;
            }
            break;
        }
        
        return IntStream.range(l, r + 1).map(i -> arr[i]).boxed().collect(Collectors.toList());
    }
}