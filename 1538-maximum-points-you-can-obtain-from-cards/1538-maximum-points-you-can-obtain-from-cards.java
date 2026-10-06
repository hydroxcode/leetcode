class Solution {
    public int maxScore(int[] arr, int k) {
        int sum = 0;
        int sumc = 0;
        int n = arr.length;

        // Initial sum of first (n-k) elements
        for (int i = 0; i < n - k; i++) {
            sum += arr[i];
        }
        int maxx = sum;
        System.out.println(maxx);

        // Sliding window over the remaining k elements
        for (int j = n - k; j < n; j++) {
            sum = sum + arr[j] - arr[j - (n - k)];
            System.out.println(sum + " " + maxx);
            maxx = Math.min(sum, maxx);
        }

        // Total sum of array
        for (int i = 0; i < arr.length; i++) {
            sumc += arr[i];
        }

        return sumc - maxx;
    }
}
