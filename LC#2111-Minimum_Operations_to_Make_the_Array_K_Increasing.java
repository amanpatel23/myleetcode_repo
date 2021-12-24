class Solution {
    public int kIncreasing(int[] arr, int k) {
        
        int n = arr.length;
        int result = 0;
        for (int i = 0; i < k; i++) {
            List<Integer> list = new ArrayList<>();
            for (int j = i; j < n; j += k) {
                list.add(arr[j]);
            }
            result += (list.size() - lnds(list));
        }
        
        return result;
    }
    
    private static int lnds(List<Integer> list) {
        
        List<Integer> temp = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            if (temp.isEmpty() || temp.get(temp.size() - 1) <= list.get(i))
                temp.add(list.get(i));
            else {
                int idx = upper_bound(0, temp.size() - 1, temp, list.get(i));
                temp.set(idx, list.get(i));
            }
        }
        
        return temp.size();
    }
    
    private static int upper_bound(int l, int r, List<Integer> list, int val) {

        while (r - l > 1) {
            int mid = (l + r) / 2;
            if (list.get(mid) > val)
                r = mid;
            else
                l = mid;
        }
        if (list.get(l) > val)
            return l;
        if (list.get(r) > val)
            return r;
        
        return -1;
    }
}