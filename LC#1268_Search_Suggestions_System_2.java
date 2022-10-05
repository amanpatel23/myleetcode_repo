class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        
        Arrays.sort(products);
        String str = "";
        List<List<String>> ans = new ArrayList<>();
        boolean flag = false;
        for (int i = 0; i < searchWord.length(); i++) {
            if (flag) {
                ans.add(new ArrayList<>());
                continue;
            }
            str += searchWord.charAt(i);
            int idx = bs(str, i + 1, products);
            if (idx == -1) {
                ans.add(new ArrayList<>());
                flag = true;
                continue;
            }
            
            List<String> curr = new ArrayList<>();
            for (int ii = idx; ii < Math.min(idx + 3, products.length); ii++) {
                String substring = products[ii]
                    .substring(0, Math.min(i + 1, products[ii].length()));
                if (!str.equals(substring)) break;
                curr.add(products[ii]);
            }
            ans.add(curr);
        }
        return ans;
    }
    
    private int bs(String str, int limit, String[] products) {
        int l = 0, r = products.length - 1;
        while (r - l > 1) {
            int mid = l + ((r - l) / 2);
            int comp = util(str, products[mid], limit);
            if (comp > 0) l = mid;
            else r = mid;
        }
        if (util(str, products[l], limit) == 0) return l;
        if (util(str, products[r], limit) == 0) return r;
        return -1;
    }
    
    private int util(String str1, String str2, int n) {
        return str1.compareTo(str2.substring(0, Math.min(n, str2.length())));
    }
}