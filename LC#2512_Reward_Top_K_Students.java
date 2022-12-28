class Solution {
    public List<Integer> topStudents(String[] positive_feedback, String[] negative_feedback, String[] report, int[] student_id, int k) {
        
        Set<String> pos = new HashSet<>();
        Set<String> neg = new HashSet<>();
        
        for (String str : positive_feedback) {
            pos.add(str);
        }
        for (String str : negative_feedback) {
            neg.add(str);
        }
        
        List<int[]> tempAns = new ArrayList<>();
        int n = report.length;
        for (int i = 0; i < n; i++) {
            String[] arr = report[i].split(" ");
            int cnt = 0;
            for (String str : arr) {
                if (pos.contains(str)) cnt += 3;
                else if (neg.contains(str)) cnt -= 1;
            }
            tempAns.add(new int[]{student_id[i], cnt});
        }
        
        tempAns.sort((o1, o2) -> (o1[1] == o2[1]) ? (o1[0] - o2[0]) : (o2[1] - o1[1]));
        List<Integer> finalAns = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            finalAns.add(tempAns.get(i)[0]);
        }
        
        return finalAns;
    }
}