class Solution {
    public String[] largestString(int[] nums) {
        String [] ans = new String[nums.length];
        for(int i =0;i<nums.length;i++){
            ans[i]=build(nums[i]);
        }
        return ans;
    }
    private String build(int x){
        StringBuilder sb = new StringBuilder();

        int z=x/(1<<25);

        for (int i = 0;i<z;i++){
            sb.append('z');
        }
        x%=(1<<25);
        for(int i = 24;i>=0;i--){
            if((x&(1<<i))!=0){
                sb.append((char)('a'+i));
            }
        }
        return sb.toString();
    }
}