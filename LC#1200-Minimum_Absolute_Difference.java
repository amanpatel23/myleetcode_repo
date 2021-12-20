class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        
        int n = arr.length;
        Arrays.sort(arr);
        int diff = (int) (1e9);
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 1; i < n; i++) {
            int curr = arr[i] - arr[i - 1];
            if (curr > diff)
                continue;
            else if (curr < diff) {
                diff = curr;
                result.clear();
            }
            result.add(Arrays.asList(arr[i - 1], arr[i]));
        }
        
        return result;
    }
}