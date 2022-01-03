class Solution {
    public int[] recoverArray(int[] nums) {
        
        int n = nums.length;
        Set<Integer> set = new HashSet<>();
        TreeSet<Integer> tree_set = new TreeSet<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        
        int first = nums[0];
        for (int i = 0; i < n; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            tree_set.add(nums[i]);
            if ((first & 1) != (nums[i] & 1))
                continue;
            int temp = (first + nums[i]) / 2;
            int k = temp - Math.min(first, nums[i]);
            if (k != 0)
                set.add(k);
        }
        
        //System.out.println(set);
        
        int[] result = new int[n / 2];
        for (int k : set) {
            int idx = 0;
            Map<Integer, Integer> map_clone = (Map<Integer, Integer>) map.clone();
            TreeSet<Integer> tree_set_clone = (TreeSet<Integer>) tree_set.clone();
            boolean flag = true;
            while (tree_set_clone.size() > 0) {
                int x1 = tree_set_clone.first();
                map_clone.put(x1, map_clone.get(x1) - 1);
                if (map_clone.get(x1) == 0)
                    tree_set_clone.remove(x1);
                int x2 = x1 + (2 * k);
                if (!tree_set_clone.contains(x2)) {
                    flag = false;
                    break;
                }
                map_clone.put(x2, map_clone.get(x2) - 1);
                if (map_clone.get(x2) == 0)
                    tree_set_clone.remove(x2);
                
                int temp = (x1 + x2) / 2;
                result[idx] = temp;
                idx++;
            }
            
            if (flag)
                return result;
        }
            
        return (new int[]{});
    }
}