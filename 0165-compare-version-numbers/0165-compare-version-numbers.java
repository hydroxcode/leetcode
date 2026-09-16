class Solution {
    public int compareVersion(String version1, String version2) {
        int i = 0, j = 0;
        int n = version1.length(), m = version2.length();
        
        while (i < n || j < m) {
            long x = 0;
            while (i < n && version1.charAt(i) != '.') {
                x = x * 10 + (version1.charAt(i) - '0');
                i++;
            }
            i++; 
            
            long y = 0;
            while (j < m && version2.charAt(j) != '.') {
                y = y * 10 + (version2.charAt(j) - '0');
                j++;
            }
            j++;
            
            if (x > y) return 1;
            if (x < y) return -1;
        }
        return 0;
    }
}
