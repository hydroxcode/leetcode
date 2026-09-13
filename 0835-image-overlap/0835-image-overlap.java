import java.util.*;

class Solution {
    public int largestOverlap(int[][] img1, int[][] img2) {
        int n = img1.length;
        List<int[]> ones1 = new ArrayList<>();
        List<int[]> ones2 = new ArrayList<>();
        
        // Collect coordinates of 1s
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (img1[i][j] == 1) ones1.add(new int[]{i, j});
                if (img2[i][j] == 1) ones2.add(new int[]{i, j});
            }
        }
        
        Map<String, Integer> countMap = new HashMap<>();
        int maxOverlap = 0;
        
        // Compute translation vectors
        for (int[] a : ones1) {
            for (int[] b : ones2) {
                String key = (b[0] - a[0]) + "," + (b[1] - a[1]);
                int val = countMap.getOrDefault(key, 0) + 1;
                countMap.put(key, val);
                maxOverlap = Math.max(maxOverlap, val);
            }
        }
        
        return maxOverlap;
    }
}
