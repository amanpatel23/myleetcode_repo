class Solution {
    public int wordCount(String[] startWords, String[] targetWords) {

        Map<Integer, Set<String>> map = new HashMap<>();
        for (String x : startWords) {
            int n = x.length();
            if (!map.containsKey(n))
                map.put(n, new HashSet<>());
            map.get(n).add(sortedString(x));
        }

        int result = 0;
        for (String x : targetWords) {
            int n = x.length();
            
            if (!map.containsKey(n - 1))
                continue;

            String sorted = sortedString(x);
            for (int i = 0; i < n; i++) {
                StringBuilder temp = new StringBuilder();
                for (int j = 0; j < n; j++) {
                    if (j == i)
                        continue;
                    temp.append(sorted.charAt(j));
                }
                
                String tempStr = temp.toString();
                if (map.get(n - 1).contains(tempStr)) {
                    result++;
                    break;
                }
            }
        }
        
        return result;
    }
    
    private static String sortedString(String str) {
        char[] temp = str.toCharArray();
        Arrays.sort(temp);
        return new String(temp);
    }
}