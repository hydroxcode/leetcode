class Solution {
    public int minOperation(String s , char ch) {
        int a = 0;
        int n = s.length();

        for(int i = 0 ; i<n ; i++){
            if(i%2 == 0 && s.charAt(i) != ch) a++;
            else if (i%2 == 1 && s.charAt(i) == ch) a++;
        }
        return a;
    }
    public int minOperations(String s){
        int opt1 = minOperation(s, '0'); 
        int opt2 = minOperation(s, '1');

        return Math.min(opt1 , opt2);
    }
}