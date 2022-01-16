class Solution {
    public int minMoves(int target, int maxDoubles) {
        
        if (target == 1)
            return 0;
        if (maxDoubles == 0)
            return (target - 1);

        int num = target;
        int x = maxDoubles;
        while (num > 1 && x > 0) {
            if ((num & 1) == 0) {
                num /= 2;
                x--;
            }
            else
                num--;
        }
        
        return (num - 1);
    }
}