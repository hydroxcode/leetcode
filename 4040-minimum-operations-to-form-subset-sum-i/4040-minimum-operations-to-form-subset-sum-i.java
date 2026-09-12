class Solution {
    public int minOperations(int[] nums, int sum) {
        int INF = 100000000;
        int[] dp = new int[sum+1];

        java.util.Arrays.fill(dp,INF);
        dp[0]=0;
        for(int x : nums){
            int[] ndp = dp.clone();

            int v =x , cost = 0;
            while(v<=sum){
                for(int s=0;s+v<=sum;s++)
                    if(dp[s]!=INF)
                        ndp[s+v]=Math.min(ndp[s+v],dp[s]+cost);
                v*=2;
                cost++;
            }
            v=x/2;
            cost=1;
            while(v>0){
                for(int s =0; s+v<=sum;s++)
                    if(dp[s]!=INF)
                        ndp[s+v]=Math.min(ndp[s+v],dp[s]+cost);
                v/=2;
                cost++;
            }
            dp =ndp;
        }
        return dp[sum]==INF?-1:dp[sum];
    }
}