class Solution {
    public int[] countRectangles(int[][] rectangles, int[][] points) {
        
        List<List<Integer>> heights = new ArrayList<>();
        for (int i = 0; i <= 100; i++) heights.add(new ArrayList<>());
        for (int[] arr : rectangles) {
            heights.get(arr[1]).add(arr[0]);
        }
        for (int i = 1; i <= 100; i++) Collections.sort(heights.get(i));
        
        int n = points.length;
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            for (int h = points[i][1]; h <= 100; h++) {
                result[i] += util(heights.get(h), points[i][0]);
            }
        }
        
        return result;
    }
    
    private static int util(List<Integer> list, int len) {
        int size = list.size();
        if (size == 0) return 0;
        int l = 0, r = size - 1;
        while (r - l > 1) {
            int mid = l + ((r - l) / 2);
            if (list.get(mid) >= len) r = mid;
            else l = mid;
        }
        if (list.get(l) >= len) return (size - l);
        else if (list.get(r) >= len) return (size - r);
        else return 0;
    }
}