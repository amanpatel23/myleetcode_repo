class Solution {
    public int numberOfWeakCharacters(int[][] arr) {
        
        int n = arr.length;
        Arrays.sort(arr, Comparator.comparingInt(x -> x[0]));
        int[] suffix_max = new int[n];
        suffix_max[n - 1] = arr[n - 1][1];
        for (int i = n - 2; i >= 0; i--) 
            suffix_max[i] = Math.max(arr[i][1], suffix_max[i + 1]);
        int j = 0;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            while (j < n && arr[i][0] == arr[j][0]) j++;
            if (j == n) break;
            if (arr[i][1] < suffix_max[j]) ans++;
        }
        return ans;
    }
}