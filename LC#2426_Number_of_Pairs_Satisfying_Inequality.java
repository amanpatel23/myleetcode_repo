class Solution {
    public long numberOfPairs(int[] nums1, int[] nums2, int diff) {

        int n = nums1.length;
        int[] diff_arr = new int[n + 1];
        for (int i = 1; i <= n; i++) diff_arr[i] = nums1[i - 1] - nums2[i - 1];

        MergeSorTree mst = new MergeSorTree(n, diff_arr);
        long ans = 0;
        for (int i = 2; i <= n; i++) {
            ans += mst.query(1, 1, n, 1, i - 1, diff + diff_arr[i]);
        }
        return ans;
    }

    private static class MergeSorTree {
        private static int n;
        private static int[] arr;
        private static List<List<Integer>> st;
        MergeSorTree(int _n, int[] _arr) {
            n = _n;
            arr = _arr;
            st = new ArrayList<>();
            for (int i = 0; i <= ((4 * n) + 5); i++) {
                st.add(new ArrayList<>());
            }

            build(1, 1, n);
        }

        private static void build(int si, int ss, int se) {
            if (ss == se) {
                st.get(si).add(arr[ss]);
                return;
            }

            int mid = ss + ((se - ss) / 2);
            build(2 * si, ss, mid);
            build((2 * si) + 1, mid + 1, se);

            int i = 0, j = 0;
            while (i < st.get(2 * si).size() && j < st.get((2 * si) + 1).size()) {
                if (st.get(2 * si).get(i) <= st.get((2 * si) + 1).get(j)) {
                    st.get(si).add(st.get(2 * si).get(i++));
                } else {
                    st.get(si).add(st.get((2 * si) + 1).get(j++));
                }
            }

            while (i < st.get(2 * si).size()) {
                st.get(si).add(st.get(2 * si).get(i++));
            }
            while (j < st.get((2 * si) + 1).size()) {
                st.get(si).add(st.get((2 * si) + 1).get(j++));
            }
        }

        int query(int si, int ss, int se, int qs, int qe, int k) {
            if (ss > qe || se < qs) return 0;
            if (ss >= qs && se <= qe) {
                return bs(st.get(si), k);
            }

            int mid = ss + ((se - ss) / 2);
            int l = query(2 * si, ss, mid, qs, qe, k);
            int r = query((2 * si) + 1, mid + 1, se, qs, qe, k);
            return (l + r);
        }

        int bs(List<Integer> list, int k) {
            if (list.size() == 0) return 0;
            int l = 0, r = list.size() - 1;
            while (r - l > 1) {
                int mid = l + ((r - l) / 2);
                if (list.get(mid) <= k) l = mid;
                else r = mid;
            }
            if (list.get(r) <= k) return (r + 1);
            else if (list.get(l) <= k) return (l + 1);
            return 0;
        }
    }
}