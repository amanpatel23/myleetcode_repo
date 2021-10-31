class Solution {
    public int[] platesBetweenCandles(String s, int[][] queries) {

        int n = s.length();
        ArrayList<Integer> candles = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '|')
                candles.add(i);
        }
        
        //System.out.println(candles);
        int cN = candles.size();
        int qN = queries.length;
        int[] result = new int[qN];
        for (int i = 0; i < qN; i++) {
            int left = queries[i][0], right = queries[i][1];
            //System.out.println(left + " " + right);
            
            int l = 0, r = cN - 1;
            while (r - l > 1) {
                int mid = l + ((r - l) / 2);
                if (candles.get(mid) >= left)
                    r = mid;
                else
                    l = mid;
            }
            
            int idx1 = -1;
            if (l < cN && (candles.get(l) >= left && candles.get(l) <= right))
                idx1 = l;
            else if (r < cN && (candles.get(r) >= left && candles.get(r) <= right))
                idx1 = r;
            
            l = 0;
            r = cN - 1;
            while (r - l > 1) {
                int mid = l + ((r - l) / 2);
                if (candles.get(mid) <= right)
                    l = mid;
                else
                    r = mid;
            }
            
            int idx2 = -1;
            
            if (r < cN && (candles.get(r) >= left && candles.get(r) <= right))
                idx2 = r;
            else if (l < cN && (candles.get(l) >= left && candles.get(l) <= right))
                idx2 = l;
            
            //System.out.println(idx1 + " " + idx2);
            if (idx1 == -1 || idx2 == -1)
                result[i] = 0;
            else {
                int count = candles.get(idx2) - candles.get(idx1) - 1 - (idx2 - idx1 - 1);
                result[i] = count;
            }
        }
        
        return result;
    }
}