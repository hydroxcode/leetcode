import java.util.*;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] index = new int[128];
        Arrays.fill(index, -1);
        int maxLength = 0, start = 0;
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (index[c] >= start) {
                start = index[c] + 1;
            }
            index[c] = i;
            maxLength = Math.max(maxLength, i - start + 1);
        }
        
        return maxLength;
    }
}