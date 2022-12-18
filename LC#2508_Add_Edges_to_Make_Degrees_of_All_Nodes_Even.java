class Solution {
    public boolean isPossible(int n, List<List<Integer>> edges) {
        
        int[] arr = new int[4];
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }
        for (List<Integer> list : edges) {
            int a = list.get(0) - 1;
            int b = list.get(1) - 1;
            
            adjList.get(a).add(b);
            adjList.get(b).add(a);
        }
        
        for (int i = 0; i < n; i++) {
            if ((adjList.get(i).size() & 1) == 1) {
                cnt++;
                arr[idx] = i;
                idx = (idx + 1) % 4;
            }
        }
        
        if (cnt > 4) return false;
        
        if (cnt == 0) return true;
        if (cnt == 2) {
            int aa = arr[0], bb = arr[1];
            for (int i = 0; i < n; i++) {
                if (!adjList.get(i).contains(aa) && !adjList.get(i).contains(bb)) {
                    return true;
                }
            }
            return false;
        }
        
        if (cnt == 4) {
            int aa = arr[0], bb = arr[1], cc = arr[2], dd = arr[3];
            if (!adjList.get(aa).contains(bb) && !adjList.get(cc).contains(dd)) {
                return true;
            }
            if (!adjList.get(aa).contains(cc) && !adjList.get(bb).contains(dd)) {
                return true;
            }
            if (!adjList.get(aa).contains(dd) && !adjList.get(bb).contains(cc)) {
                return true;
            }
            return false;
        }
        
        return false;
        
    }
}