class Solution {
    public int[] sortByBits(int[] arr) {
        Integer[] a = new Integer[arr.length];
        for (int i = 0; i < arr.length; i++) {
            a[i] = arr[i];
        }
        java.util.Arrays.sort(a, (x, y) -> {
            int cx = Integer.bitCount(x);
            int cy = Integer.bitCount(y);
            if (cx == cy) return x - y;
            return cx - cy;
        });
        for (int i = 0; i < arr.length; i++) {
            arr[i] = a[i];
        }
        return arr;
    }
}