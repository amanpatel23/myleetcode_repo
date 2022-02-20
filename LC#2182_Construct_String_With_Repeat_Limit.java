class Solution {
    public String repeatLimitedString(String s, int k) {

        int n = s.length();
        List<Character> list = new ArrayList<>();
        for (int i = 0; i < n; i++)
            list.add(s.charAt(i));
        list.sort(Comparator.reverseOrder());

        int i, j = 1;
        int len = 0;
        char prev = list.get(0);
        for (i = 0; i < n; i++) {
            if (i == j)
                j++;
            
            if (list.get(i) == prev)
                len++;
            else {
                prev = list.get(i);
                len = 1;
            }

            if (len > k) {
                for (; j < n; j++) {
                    if (list.get(j) != list.get(i))
                        break;
                }

                if (j >= n)
                    break;
                char temp = list.get(i);
                list.set(i, list.get(j));
                list.set(j, temp);
                prev = list.get(i);
                len = 1;
            }
        }

        StringBuilder result = new StringBuilder();
        for (int idx = 0; idx < i; idx++)
            result.append(list.get(idx));
        return result.toString();
    }
}