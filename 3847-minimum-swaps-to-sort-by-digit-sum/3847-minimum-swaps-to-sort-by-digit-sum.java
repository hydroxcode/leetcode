class Solution {
    public int minSwaps(int[] nums) {
        int n=nums.length;
        int drr[][]=new int[n][2];

        for(int i=0; i<n; i++){
            drr[i][0]=nums[i];
            int val=nums[i];
            int sum=0;

            while(val!=0){
                int dig=val%10;
                sum+=dig;

                val=val/10;
            }

            drr[i][1]=sum;
        }

        Arrays.sort(drr, (a,b)->{
            if(a[1]==b[1]){
                return Integer.compare(a[0], b[0]);
            }

            return Integer.compare(a[1], b[1]);
        });

        HashMap<Integer, Integer> map=new HashMap<>();
        for(int i=0; i<n; i++){
            int val=drr[i][0];
            map.put(val, i);
        }

        int swap=0;
        int idx=0;

        while(idx<n){
            int ei=map.get(nums[idx]);

            if(ei==idx){
                idx++;
            }else{
                int temp=nums[ei];
                nums[ei]=nums[idx];
                nums[idx]=temp;

                swap++;
            }
        }

        return swap;
    }
}