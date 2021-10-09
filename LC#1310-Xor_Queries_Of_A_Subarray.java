class Solution {
    public int[] xorQueries(int[] arr, int[][] queries) {

        int n = arr.length;
        int[] prefixXor = new int[n];
        prefixXor[0] = arr[0];
        for (int i = 1; i < n; i++) {
            prefixXor[i] = prefixXor[i - 1] ^ arr[i];
        }

        int q = queries.length;
        int[] result = new int[q];
        for (int i = 0; i < q; i++) {
            int l = queries[i][0], r = queries[i][1];
            if (l == 0)
                result[i] = prefixXor[r];
            else
                result[i] = prefixXor[l - 1] ^ prefixXor[r];
        }
        
        return result;
    }
}