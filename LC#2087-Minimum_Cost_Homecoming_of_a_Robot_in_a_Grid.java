class Solution {
    public int minCost(int[] startPos, int[] homePos, int[] rowCosts, int[] colCosts) {

        int result = 0;
        if (startPos[0] <= homePos[0]) {
            for (int i = startPos[0] + 1; i <= homePos[0]; i++)
                result += rowCosts[i];
        }else {
            for (int i = startPos[0] - 1; i >= homePos[0]; i--)
                result += rowCosts[i];
        }

        if (startPos[1] <= homePos[1]) {
            for (int j = startPos[1] + 1; j <= homePos[1]; j++)
                result += colCosts[j];
        }else {
            for (int j = startPos[1] - 1; j >= homePos[1]; j--)
                result += colCosts[j];
        }

        return result;
    }
}