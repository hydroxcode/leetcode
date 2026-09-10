class Solution {
    public int smallestNumber(int n, int t) {

        while (true) {
            int pr = 1;
            int no = n;

            while (no > 0) {
                pr *= (no % 10);
                no /= 10;
            }

            if (pr % t == 0) {
                return n;
            }

            n++;
        }
    }
}