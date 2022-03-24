class Solution {
    public int numRescueBoats(int[] people, int limit) {
        
        Arrays.sort(people);
        int i = 0, j = people.length - 1;
        int cnt = 0;
        while (i <= j) {
            cnt++;
            if (people[i] + people[j] <= limit) i++;
            j--;
        }
        
        return cnt;
    }
}