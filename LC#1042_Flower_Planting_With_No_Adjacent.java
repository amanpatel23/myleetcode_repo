class Solution {
    
    private static List<List<Integer>> adjList;
    public int[] gardenNoAdj(int n, int[][] paths) {
        
        adjList = new ArrayList<>();
        for (int i = 0; i <= n; i++) adjList.add(new ArrayList<>());
        for (int[] arr : paths) {
            adjList.get(arr[0]).add(arr[1]);
            adjList.get(arr[1]).add(arr[0]);
        }
        
        int[] flower_planted = new int[n];
        Arrays.fill(flower_planted, -1);
        for (int i = 1; i <= n; i++) {
            if (flower_planted[i - 1] == -1)
                dfs(i, 1, flower_planted);
        }
        
        return flower_planted;
    }
    
    private static void dfs(int curr_garden, int curr_flower, int[] flower_planted) {
        
        flower_planted[curr_garden - 1] = curr_flower;
        for (int neighbour_garden : adjList.get(curr_garden)) {
            if (flower_planted[neighbour_garden - 1] == -1) {
                for (int next_flower = 1; next_flower <= 4; next_flower++) {
                    if (util(neighbour_garden, next_flower, flower_planted)) {
                        dfs(neighbour_garden, next_flower, flower_planted);
                        break;
                    }
                }
            }
        }
    }
    
    private static boolean util(int garden, int flower, int[] flower_planted) {
        for (int neighbour_garden : adjList.get(garden)) 
            if (flower_planted[neighbour_garden - 1] == flower) return false;
        return true;
    }
}