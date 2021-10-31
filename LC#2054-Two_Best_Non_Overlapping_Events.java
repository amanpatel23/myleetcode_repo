class Solution {
    public int maxTwoEvents(int[][] events) {

        int n = events.length;

        Comparator<int[]> myComp = Comparator.comparingInt(o -> o[0]);
        Arrays.sort(events, myComp);

        int[] maxSuffix = new int[n];
        int maxSoFar = 0;
        for (int i = (n - 1); i >= 0; i--) {
            maxSoFar = Math.max(maxSoFar, events[i][2]);
            maxSuffix[i] = maxSoFar;
        }

        int globalResult = 0;
        for (int i = 0; i < (n - 1); i++) {
            int x = events[i][1];
            int l = i + 1, r = n - 1;
            while (r - l > 1) {
                int mid = l + ((r - l) / 2);
                if (events[mid][0] > x)
                    r = mid;
                else
                    l = mid;
            }

            int another = 0;
            if (events[l][0] > x)
                another = maxSuffix[l];
            else if (events[r][0] > x)
                another = maxSuffix[r];

            int currResult = events[i][2] + another;
            globalResult = Math.max(globalResult, currResult);
        }

        globalResult = Math.max(globalResult, events[n - 1][2]);
        return globalResult;
    }
}