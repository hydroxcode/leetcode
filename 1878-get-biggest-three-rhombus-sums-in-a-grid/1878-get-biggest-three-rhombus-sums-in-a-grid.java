import java.util.*;

class Solution {
    public int[] getBiggestThree(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        TreeSet<Integer> set = new TreeSet<>(Collections.reverseOrder());

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                set.add(grid[i][j]);
                int maxSize = Math.min(Math.min(i, m - 1 - i), Math.min(j, n - 1 - j));
                for (int k = 1; k <= maxSize; k++) {
                    int sum = 0;
                    int x = i - k, y = j;
                    for (int t = 0; t < k; t++) sum += grid[x + t][y + t];
                    for (int t = 0; t < k; t++) sum += grid[x + k + t][y + k - t];
                    for (int t = 0; t < k; t++) sum += grid[x + 2 * k - t][y - t];
                    for (int t = 0; t < k; t++) sum += grid[x + k - t][y - k + t];
                    set.add(sum);
                }
            }
        }

        int size = Math.min(3, set.size());
        int[] res = new int[size];
        int idx = 0;
        for (int v : set) {
            if (idx == size) break;
            res[idx++] = v;
        }
        return res;
    }
}