class Solution {
    public int smallestIndex(int[] nums) {
       for(int i =0;i<nums.length;i++){
        int val = nums[i];
        int sum = 0 ;
        while(val>0){
        int ch = val%10;
        sum+=ch;
        val/=10;
       } 
       if(sum==i) return i;

    }
    return -1;
    }
}