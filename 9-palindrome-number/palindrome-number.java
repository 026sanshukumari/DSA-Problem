class Solution {
    public boolean isPalindrome(int x) {
        int n = x;
        long rev = 0;
        while(x > 0){
            int lastDigit = x % 10;
            rev = (rev * 10 ) + lastDigit;
            x = x / 10;
        }
            if(rev == n){
                return true;
            }
        return false;
    }
}