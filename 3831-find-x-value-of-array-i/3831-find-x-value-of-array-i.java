class Solution {
    public long[] resultArray(int[] nums, int k) {
        long[] ans = new long[k];
        long[] dp = new long[k];

        for (int num : nums) {
            int m = num % k;
            long[] next = new long[k];

            next[m] = 1;

            for (int r = 0; r < k; r++)
                next[(r * m) % k] += dp[r];

            for (int r = 0; r < k; r++)
                ans[r] += next[r];

            dp = next;
        }

        return ans;
    }
}