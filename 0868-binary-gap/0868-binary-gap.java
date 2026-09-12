public class Solution {
    public int binaryGap(int n) {
        
        int prev = -1;  
        int maxDist = 0;
        int index = 0;
        
        while(n > 0) {
            
            if((n & 1) == 1) { 
                
                if(prev != -1) {
                    int dist = index - prev;
                    maxDist = Math.max(maxDist, dist);
                }
                
                prev = index;
            }
            n = n >> 1;  
            index++;
        }
        return maxDist;
    }
}