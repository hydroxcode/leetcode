class Solution {

    int[][] st;
    int[] log;
    int n;

    public int maxValidSplits(int[] nums) {
        n = nums.length;

        if (n < 2) {
            return 0;
        }

        buildSparseTable(nums);

        int[] pref = new int[n];
        int[] suff = new int[n];

        pref[0] = nums[0];
        for (int i = 1; i < n; i++) {
            pref[i] = gcd(pref[i - 1], nums[i]);
        }

        suff[n - 1] = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            suff[i] = gcd(suff[i + 1], nums[i]);
        }

        int answer = 0;

        for (int k = 1; k < n; k++) {
            if (pref[k - 1] == suff[k]) {
                answer++;
            }
        }

        for (int remove = 0; remove < n; remove++) {

            int m = n - 1;

            if (m < 2) {
                continue;
            }

            int leftGcd = (remove > 0) ? pref[remove - 1] : 0;
            int rightGcd = (remove + 1 < n) ? suff[remove + 1] : 0;

            int totalGcd = gcd(leftGcd, rightGcd);

            int low = 1;
            int high = m;

            while (low < high) {
                int mid = low + (high - low) / 2;

                if (prefixAfterRemoval(mid, remove, pref) == totalGcd) {
                    high = mid;
                } else {
                    low = mid + 1;
                }
            }

            int first = low;

            low = 1;
            high = m;

            while (low < high) {
                int mid = low + (high - low) / 2;

                if (suffixAfterRemoval(mid, remove, suff) == totalGcd) {
                    high = mid;
                } else {
                    low = mid + 1;
                }
            }

            int suffixLength = low;

            int last = m - suffixLength;

            if (first <= last) {
                answer = Math.max(answer, last - first + 1);
            }
        }

        return answer;
    }

    private int prefixAfterRemoval(int count, int remove, int[] pref) {

        if (count <= remove) {
            return pref[count - 1];
        }

        int leftGcd = (remove > 0) ? pref[remove - 1] : 0;

        int rightGcd = rangeGcd(remove + 1, count);

        return gcd(leftGcd, rightGcd);
    }

    private int suffixAfterRemoval(int count, int remove, int[] suff) {

        int elementsRight = n - 1 - remove;

        if (count <= elementsRight) {
            return suff[n - count];
        }

        int leftGcd = rangeGcd(n - 1 - count, remove - 1);

        int rightGcd = (remove + 1 < n) ? suff[remove + 1] : 0;

        return gcd(leftGcd, rightGcd);
    }

    private void buildSparseTable(int[] nums) {

        log = new int[n + 1];

        for (int i = 2; i <= n; i++) {
            log[i] = log[i / 2] + 1;
        }

        int levels = log[n] + 1;

        st = new int[levels][n];

        for (int i = 0; i < n; i++) {
            st[0][i] = nums[i];
        }

        for (int j = 1; j < levels; j++) {

            int len = 1 << j;
            int half = len >> 1;

            for (int i = 0; i + len <= n; i++) {
                st[j][i] = gcd(
                    st[j - 1][i],
                    st[j - 1][i + half]
                );
            }
        }
    }

    private int rangeGcd(int left, int right) {

        if (left > right) {
            return 0;
        }

        int length = right - left + 1;
        int j = log[length];

        return gcd(
            st[j][left],
            st[j][right - (1 << j) + 1]
        );
    }

    private int gcd(int a, int b) {

        while (b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }

        return a;
    }
}