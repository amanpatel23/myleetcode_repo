class Solution {
    
    private static List<List<Integer>> adjList;
    public int[] gardenNoAdj(int n, int[][] paths) {
        
        adjList = new ArrayList<>();
        for (int i = 0; i <= n; i++) adjList.add(new ArrayList<>());
        for (int[] arr : paths) {
            adjList.get(arr[0] - 1).add(arr[1] - 1);
            adjList.get(arr[1] - 1).add(arr[0] - 1);
        }
        
        int[] flower_planted = new int[n];
        for (int i = 0; i < n; i++) {
            int[] temp = new int[5];
            for (int x : adjList.get(i)) temp[flower_planted[x]] = 1;
            for (int j = 1; j <= 4; j++) if (temp[j] == 0) flower_planted[i] = j;
        }
        return flower_planted;
    }
}