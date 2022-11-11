class Solution {
    
    private long[][] dp;
    public long minimumTotalDistance(List<Integer> robot, int[][] factory) {
        
        Collections.sort(robot);
        Arrays.sort(factory, Comparator.comparingInt(x -> x[0]));
        
        dp = new long[robot.size()][factory.length];
        for (long[] r : dp) Arrays.fill(r, -1);
        
        return solve(0, 0, robot, factory);
    }
    
    private long solve(int roboIt, int factIt, List<Integer> robot, int[][] factory) {
        if (roboIt == robot.size()) return 0;
        if (factIt == factory.length) return (long) 1e12;
        
        if (dp[roboIt][factIt] != -1) return dp[roboIt][factIt];
        
        int xx = factory[factIt][1];
        long ans = solve(roboIt, factIt + 1, robot, factory);
        int ii = roboIt;
        long sum = 0;
        while (xx-- > 0 && ii < robot.size()) {
            sum += Math.abs(factory[factIt][0] - robot.get(ii));
            ans = Math.min(ans, sum + solve(ii + 1, factIt + 1, robot, factory));
            ii++;
        }
        
        return dp[roboIt][factIt] = ans;
    }
}