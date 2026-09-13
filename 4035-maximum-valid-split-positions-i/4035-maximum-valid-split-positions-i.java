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

        // Prefix and suffix gcd
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

        // Case 1: Don't remove anything
        answer = Math.max(answer, scoreWithoutRemoval(nums, pref, suff));

        // Case 2: Remove exactly one element
        int m = n - 1;

        if (m < 2) {
            return answer;
        }

        for (int remove = 0; remove < n; remove++) {

            // GCD of the whole array after removing nums[remove]
            int leftGcd = (remove > 0) ? pref[remove - 1] : 0;
            int rightGcd = (remove + 1 < n) ? suff[remove + 1] : 0;

            int totalGcd = gcd(leftGcd, rightGcd);

            /*
             * Find the first split position L where
             * gcd(left part) == totalGcd.
             */
            int lo = 1;
            int hi = m;

            while (lo < hi) {
                int mid = lo + (hi - lo) / 2;

                if (prefixGcdAfterRemoval(mid, remove) == totalGcd) {
                    hi = mid;
                } else {
                    lo = mid + 1;
                }
            }

            int L = lo;

            /*
             * Find the smallest suffix length whose gcd
             * becomes totalGcd.
             */
            lo = 1;
            hi = m;

            while (lo < hi) {
                int mid = lo + (hi - lo) / 2;

                if (suffixGcdAfterRemoval(mid, remove) == totalGcd) {
                    hi = mid;
                } else {
                    lo = mid + 1;
                }
            }

            int suffixLength = lo;

            // Last valid split position
            int R = m - suffixLength;

            if (L <= R) {
                answer = Math.max(answer, R - L + 1);
            }
        }

        return answer;
    }

    // --------------------------------------------------
    // Score when we don't remove any element
    // --------------------------------------------------
    private int scoreWithoutRemoval(int[] nums, int[] pref, int[] suff) {

        int totalGcd = pref[n - 1];

        int L = n;

        int g = 0;

        for (int i = 0; i < n - 1; i++) {
            g = gcd(g, nums[i]);

            if (g == totalGcd) {
                L = i + 1;
                break;
            }
        }

        int R = 0;

        g = 0;

        for (int i = n - 1; i >= 1; i--) {
            g = gcd(g, nums[i]);

            if (g == totalGcd) {
                R = i;
                break;
            }
        }

        return Math.max(0, R - L + 1);
    }

    // --------------------------------------------------
    // GCD of first 'count' elements after removing index
    // --------------------------------------------------
    private int prefixGcdAfterRemoval(int count, int remove) {

        // Last original index included
        int lastIndex;

        if (count <= remove) {
            lastIndex = count - 1;
        } else {
            lastIndex = count;
        }

        int g = 0;

        // Part before removed element
        if (remove > 0) {
            int end = Math.min(remove - 1, lastIndex);

            if (end >= 0) {
                g = rangeGcd(0, end);
            }
        }

        // Part after removed element
        if (lastIndex > remove) {
            g = gcd(g, rangeGcd(remove + 1, lastIndex));
        }

        return g;
    }

    // --------------------------------------------------
    // GCD of last 'count' elements after removing index
    // --------------------------------------------------
    private int suffixGcdAfterRemoval(int count, int remove) {

        int start;

        int elementsAfterRemove = n - 1 - remove;

        if (count <= elementsAfterRemove) {
            start = n - count;
        } else {
            start = n - 1 - count;
        }

        int g = 0;

        // Part before removed element
        if (start <= remove - 1) {
            g = rangeGcd(start, remove - 1);
        }

        // Part after removed element
        if (start < n && start <= n - 1) {
            int rightStart = Math.max(start, remove + 1);

            if (rightStart <= n - 1) {
                g = gcd(g, rangeGcd(rightStart, n - 1));
            }
        }

        return g;
    }

    // --------------------------------------------------
    // Sparse Table
    // --------------------------------------------------
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

            for (int i = 0; i + len <= n; i++) {
                st[j][i] = gcd(
                    st[j - 1][i],
                    st[j - 1][i + (len >> 1)]
                );
            }
        }
    }

    // --------------------------------------------------
    // Range GCD
    // --------------------------------------------------
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

    // --------------------------------------------------
    // GCD
    // --------------------------------------------------
    private int gcd(int a, int b) {

        while (b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }

        return Math.abs(a);
    }
}