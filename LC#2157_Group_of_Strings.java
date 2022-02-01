class Solution {
    public int[] groupStrings(String[] words) {
        
        int n = words.length;
        int[] arr = new int[n];
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int i = 0; i < n; i++) {
            int mask = 0;
            for (char c : words[i].toCharArray()) {
                int idx = c - 'a';
                mask |= (1 << idx);
            }
            arr[i] = mask;
            map.put(mask, i);
        }
        
        UnionFind uf = new UnionFind(n);
        for (int i = 0; i < n; i++) {
            int num = arr[i];

            for (int bit = 0; bit < 26; bit++) {
                int num_new = (num ^ (1 << bit));
                if (map.containsKey(num_new)) {
                    uf.union(i, map.get(num_new));
                }
            }
            
            for (int bit1 = 0; bit1 < 26; bit1++) {
                if ((1 & (num >> bit1)) == 1) {
                    int num_new = num ^ (1 << bit1);
                    for (int bit2 = 0; bit2 < 26; bit2++) {
                        if ((1 & (num_new >> bit2)) == 0) {
                            int num_new_new = num_new | (1 << bit2);
                            if (map.containsKey(num_new_new)) {
                                uf.union(i, map.get(num_new_new));
                            }
                        }
                    }
                }
            }
        }
        
        int total_gr = uf.count_groups();
        int max_size = uf.max_group_size();
        return new int[]{total_gr, max_size};
    }
    
    private static class UnionFind {

        private final int[] parent;
        private final int[] size;

        private final int len;
        UnionFind(int n) {
            parent = new int[n + 5];
            size = new int[n + 5];
            len = n;
            for (int i = 0; i <= n; i++) {
                parent[i] = i;
                size[i] = 1;
            }
        }

        private int find(int i) {
            if (parent[i] == i)
                return i;
            return parent[i] = find(parent[i]);
        }

        private void union(int a, int b) {
            a = find(a);
            b = find(b);
            if (a != b) {
                if (size[a] < size[b]) {
                    int temp = a;
                    a = b;
                    b = temp;
                }
                parent[b] = a;
                size[a] += size[b];
            }
        }
        
        private int count_groups() {
            Set<Integer> set = new HashSet<>();
            for (int i = 0; i < len; i++)
                set.add(find(i));
            return set.size();
        }
        
        private int max_group_size() {
            return Arrays.stream(size).max().getAsInt();
        }
    }
}