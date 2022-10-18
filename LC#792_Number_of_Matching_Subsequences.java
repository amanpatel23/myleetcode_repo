class Solution {
    
    private Node root;
    public int numMatchingSubseq(String s, String[] words) {
        List<List<Integer>> occu = new ArrayList<>();
        for (int i = 0; i < 26; i++) 
            occu.add(new ArrayList<>());
        
        int n = s.length();
        for (int i = 0; i < n; i++) 
            occu.get(s.charAt(i) - 'a').add(i);
        
        root = new Node();
        for (String str : words) insert(str);
        
        int ans = 0;
        Queue<Node> qq_ff = new LinkedList<>();
        Queue<Integer> qq_ss = new LinkedList<>();
        
        qq_ff.add(root); qq_ss.add(-1);
        while (!qq_ff.isEmpty()) {
            Node nfront = qq_ff.poll();
            int idxfront = qq_ss.poll();
            
            ans += nfront.isEnd;
            
            for (int i = 0; i < 26; i++) {
                if (nfront.links[i] == null) continue;
                int idx = bs(occu.get(i), idxfront);
                if (idx == -1) continue;
                qq_ff.add(nfront.links[i]);
                qq_ss.add(idx);
            }
        }
        
        return ans;
    }
    
    private int bs(List<Integer> list, int x) {
        if (list.size() == 0) return -1;
        int l = 0 , r = list.size() - 1;
        while (r - l > 1) {
            int mid = l + ((r - l) / 2);
            if (list.get(mid) <= x) l = mid;
            else r = mid;
        }
        if (list.get(l) > x) return list.get(l);
        if (list.get(r) > x) return list.get(r);
        return -1;
    }
    
    private class Node {
        Node[] links;
        int isEnd;
        Node() {
            links = new Node[26];
            isEnd = 0;
        }
    }
    
    private void insert(String str) {
        Node curr = root;
        for (char c : str.toCharArray()) {
            int ascii = c - 'a';
            if (curr.links[ascii] == null) 
                curr.links[ascii] = new Node();
            curr = curr.links[ascii];
        }
        curr.isEnd++;
    }
}