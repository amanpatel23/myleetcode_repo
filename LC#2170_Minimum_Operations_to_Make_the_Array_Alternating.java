class Solution {
    public int minimumOperations(int[] nums) {

        int maxV = (int) (1e5 + 10);
        int n = nums.length;
        if (n == 1)
            return 0;
        
        int evenIdx = n / 2, oddIdx = n / 2;
        if ((n & 1) == 1)
            evenIdx += 1;
        int[] freq1 = new int[maxV], freq2 = new int[maxV];
        for (int i = 0; i < n; i++) {
            if ((i & 1) == 0)
                freq1[nums[i]]++;
            else
                freq2[nums[i]]++;
        }

        List<Integer> list1 = new ArrayList<>(), list2 = new ArrayList<>();
        for (int i = 1; i < maxV; i++) {
            list1.add(i);
            list2.add(i);
        }

        list1.sort(Comparator.comparingInt(i -> -freq1[i]));
        list2.sort(Comparator.comparingInt(i -> -freq2[i]));
        
        int result = (int) (1e9);
        for (int x : list1) {
            int y = (list2.get(0) == x) ? list2.get(1) : list2.get(0);
            int curr = (evenIdx - freq1[x]) + (oddIdx - freq2[y]);
            result = Math.min(result, curr);
        }
        
        return result;
    }
}