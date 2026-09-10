class Solution {
    int n;
    int[] suffix;
    Integer[][] dp;

    public int stoneGameII(int[] piles) {
        n = piles.length;

        // suffix[i] = piles[i] se end tak total stones
        suffix = new int[n + 1];

        for (int i = n - 1; i >= 0; i--) {
            suffix[i] = suffix[i + 1] + piles[i];
        }

        // dp[i][M]
        dp = new Integer[n][n + 1];

        return solve(0, 1);
    }

    private int solve(int i, int M) {

        // Agar saare remaining piles le sakte hain
        if (i + 2 * M >= n) {
            return suffix[i];
        }

        // Already calculated
        if (dp[i][M] != null) {
            return dp[i][M];
        }

        int best = 0;

        // X = kitne piles current player lega
        for (int X = 1; X <= 2 * M; X++) {

            // Opponent ki maximum stones
            int opponent = solve(
                i + X,
                Math.max(M, X)
            );

            // Current player ke stones
            int current = suffix[i] - opponent;

            best = Math.max(best, current);
        }

        return dp[i][M] = best;
    }
}