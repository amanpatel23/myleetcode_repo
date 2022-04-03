class Solution {
    public int convertTime(String current, String correct) {
        
        String[] arr1 = current.split(":");
        String[] arr2 = correct.split(":");
        
        int diff = 60 * (Integer.parseInt(arr2[0]) - Integer.parseInt(arr1[0]));
        diff += (Integer.parseInt(arr2[1]) - Integer.parseInt(arr1[1]));
        //System.out.println(diff);
        
        int[] operations = new int[]{60, 15, 5, 1};
        int result = 0;
        int i = 0;
        while (diff > 0) {
            int div = diff / operations[i];
            result += div;
            diff %= operations[i];
            i++;
        }
        
        return result;
    }
}