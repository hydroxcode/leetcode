class Solution {
    public int fib(int n) {
        if (n <= 1) return n;

        int[] Dp = new int[n + 1];
        Dp[0] = 0;
        Dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            Dp[i] = Dp[i - 1] + Dp[i - 2];
        }

        return Dp[n];
    }
}