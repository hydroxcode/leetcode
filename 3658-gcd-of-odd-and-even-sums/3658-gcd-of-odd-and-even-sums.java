class Solution {
    public int gcdOfOddEvenSums(int n) {
       int sumOdd = (int) Math.pow(n, 2);
        int sumEven = n * (n + 1);
        int ans = 1;

        for (int i = sumOdd; i > 0; i--) {
            if (sumEven % i == 0 && sumOdd % i == 0) {
                ans = i;
                break;
            }
        }
        return ans;
    }
}