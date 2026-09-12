class Solution {
    public boolean uniformArray(int[] nums1) {
        int[]rev=nums1;
        int odd=0,even=0;
        int min = Integer.MAX_VALUE;

        for(int x : rev){
            if(x%2==0)even++;
            else odd++;
            min=Math.min(min,x);
        }
        if(even==rev.length) return true;
        if(odd==rev.length) return true;
        return min%2==1;
    }
}