class Solution {
    public int[] executeInstructions(int n, int[] startPos, String s) {

        int m = s.length();
        
        int[] result = new int[m];
        Arrays.fill(result, 0);
        
        int x = startPos[0], y = startPos[1];
        
        for (int i = 0; i < m; i++) {
            int curr_x = x, curr_y = y;
            int steps = 0;
            int j = i;
            while (j < m) {
                
                char dir = s.charAt(j);
                boolean temp = canBeExecuted(curr_x, curr_y, dir, n);
                if (!temp)
                    break;

                switch (dir) {
                    case 'R':
                        curr_y++;
                        break;
                    case 'L':
                        curr_y--;
                        break;
                    case 'U':
                        curr_x--;
                        break;
                    default:
                        curr_x++;
                }

                steps++;
                j++;
            }

        
            result[i] = steps;
        }
        
        return result;
    }
    
    private static boolean canBeExecuted(int curr_x, int curr_y, int dir, int n) {

        int temp_x = curr_x, temp_y = curr_y;
        switch (dir) {
            case 'R':
                temp_y++;
                break;
            case 'L':
                temp_y--;
                break;
            case 'U':
                temp_x--;
                break;
            default:
                temp_x++;
        }

        return temp_x >= 0 && temp_x < n && temp_y >= 0 && temp_y < n;
    }
}