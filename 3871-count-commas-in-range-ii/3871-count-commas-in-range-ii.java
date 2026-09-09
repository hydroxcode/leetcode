public class Solution {
    public long countCommas(long n) {
        if (n < 1000) return 0;

        long num = 0;

        if (n >= 1000) {
            num += n - 1000 + 1;
        }
        if (n >= 1_000_000) {
            num += n - 1_000_000 + 1;
        }
        if (n >= 1_000_000_000L) {
            num += n - 1_000_000_000L + 1;
        }
        if (n >= 1_000_000_000_000L) {
            num += n - 1_000_000_000_000L + 1;
        }
        if (n >= 1_000_000_000_000_000L) {
            num += n - 1_000_000_000_000_000L + 1;
        }

        return num;
    }

}
