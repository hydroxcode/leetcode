class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }

        long n = x;
        long revnum = 0;

        while (n > 0) {
            long d = n % 10;          
            revnum = revnum * 10 + d; 
            n = n / 10;               
        }
        return (revnum == x);
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.isPalindrome(121)); 
        System.out.println(sol.isPalindrome(-121));
    }
}
