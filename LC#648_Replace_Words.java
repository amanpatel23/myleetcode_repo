class Solution {
    public String replaceWords(List<String> dict, String sentence) {
        
        Node root = new Node();
        
        for (String str : dict) {
            Node curr = root;
            for (char c : str.toCharArray()) {
                int ascii = c - 'a';
                if (curr.links[ascii] == null)
                    curr.links[ascii] = new Node();
                curr = curr.links[ascii];
            }
            curr.isEnd = true;
        }
        
        String[] arr = sentence.split(" ");
        StringBuilder ans = new StringBuilder();
        outer: 
        for (String str : arr) {
            Node curr = root;
            for (int i = 0; i < str.length(); i++) {
                int ascii = str.charAt(i) - 'a';
                if (curr.links[ascii] == null) {
                    ans.append(" ").append(str);
                    continue outer;
                }
                curr = curr.links[ascii];
                if (curr.isEnd) {
                    ans.append(" ").append(str.substring(0, i + 1));
                    continue outer;
                }
            }
            ans.append(" ").append(str);
        }
        
        return ans.toString().substring(1);
    }
    
    private class Node {
        Node[] links;
        boolean isEnd;
        Node() {
            links = new Node[26];
            isEnd = false;
        }
    }
}