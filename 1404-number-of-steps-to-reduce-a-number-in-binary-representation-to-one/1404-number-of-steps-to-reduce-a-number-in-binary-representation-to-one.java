class Solution {
    public int numSteps(String s) {
        int st=0;
        int ca=0;
        for(int i = s.length()-1;i>0;i--){
            int bit = s.charAt(i) - '0' + ca;
            if(bit % 2 == 0){
                st++;
            }else {
                st+=2;
                ca = 1;
            }
        }
        return st + ca;
    }
}