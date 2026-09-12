class Solution {
    public int mySqrt(int x) {
        if (x == 0 || x == 1) return x;

        int lo = 0, hi = x;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            long square = (long) mid * mid;

            if (square == x) {
                return mid;
            } else if (square > x) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return hi;
    }
}
