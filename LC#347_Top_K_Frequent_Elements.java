class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) map.put(num, map.getOrDefault(num, 0) + 1);
        
        int n = map.size();
        int[][] arr = new int[n][2];
        int idx = 0;
        for (int _key : map.keySet()) arr[idx++] = new int[]{_key, -map.get(_key)};
        
        quickSelect(arr, k, 0, n - 1);
        int[] result = new int[k];
        for (int i = 0; i < k; i++) result[i] = arr[i][0];
        return result;
    }
    
    private static int quickSelect(int[][] arr, int k, int lo, int hi) {
        
        int pivotIdx = quickSort(arr, lo, hi);
        if (pivotIdx > (k - 1)) return quickSelect(arr, k, lo, pivotIdx - 1);
        else if (pivotIdx < (k - 1)) return quickSelect(arr, k, pivotIdx + 1, hi);
        return pivotIdx;
    }
    
    private static int quickSort(int[][] arr, int lo, int hi) {
        
        int i = lo, j = lo;
        while (i < hi) {
            if (arr[i][1] < arr[hi][1]) {
                swap(arr, i, j);
                j++;
            }
            i++;
        }
        swap(arr, j, hi);
        return j;
    }
    
    private static void swap(int[][] arr, int i, int j) {
        int[] temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}