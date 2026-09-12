class Solution {
    static final long MOD = 1000000007L;
    public int sumDecoded(long[] nums) {
        long ans = 0;
        for(long n : nums){
            int w=(int)(n%10);
            String s=""+(n/10);

            long x = Long.parseLong(s.substring(0,w));
            long y = Long.parseLong(s.substring(w));

            ans = (ans+power(x,y))%MOD;
        }
        return (int) ans;
        
    }

    long power(long a , long b){
        long res = 1;
        while(b>0){
            if((b&1)==1)
                res = res*a%MOD;
            a=a*a%MOD;
            b>>=1;
        }
        return res;
    }
    
}