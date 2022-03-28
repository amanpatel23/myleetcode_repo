class Solution {
    
    private static int[] arr;
    public int[][] kClosest(int[][] points, int k) {
        
        int n = points.length;
        arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = i;
        
        quickSort(0, n - 1, points, k - 1);
        int[][] result = new int[k][2];
        for (int i = 0; i < k; i++) {
            result[i] = points[arr[i]];
        }
        return result;
    }
    
    private static void quickSort(int low, int high, int[][] points, int k) {
        
        int pivotIdx = quickSelect(low, high, points);
        if (pivotIdx == k) return;
        else if (pivotIdx > k) quickSort(low, pivotIdx - 1, points, k);
        else quickSort(pivotIdx + 1, high, points, k);
    }
    
    private static int quickSelect(int low, int high, int[][] points) {
        if (low == high) return low;
        
        int dist1 = dist(arr[high], points);
        int i = low, j = low;
        while (i < high) {
            int dist2 = dist(arr[i], points);
            if (dist2 < dist1) {
                swap(i, j);
                j++;
            }
            i++;
        }
        
        swap(j, high);
        return j;
    }
    
    private static void swap(int i, int j) {
        int temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
    }
    
    private static int dist(int i, int[][] points) {
        int x = points[i][0], y = points[i][1];
        int dist = (x * x) + (y * y);
        return dist;
    }
}