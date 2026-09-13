class Solution {
    public int countSpecialIntegers(int[] nums) {
        int ans = 0;

        for (int x = 1;x<=100;x++){
            int first=-1,last=-1,count=0;

            for(int i=0;i<nums.length;i++){
                if(nums[i]==x){
                    if(first==-1)first=i;
                    last=i;
                    count++;
                }
            }
            if(count>0 && last-first +1 == count)
                ans++;
        }
        return ans;
    }
}