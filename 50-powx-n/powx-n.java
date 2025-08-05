class Solution {
    public double myPow(double x, int n) {
        if(n < 0){
            long val = (long)n;
            val = Math.abs(val);
            return 1.0 / helper(x,val);
        }else{
            return helper(x,n);
        }
    }
    private double helper(double x, long n){
        if(n == 0) return 1;
        double temp = helper(x,n/2);
        temp = temp * temp;
        if(n % 2 != 0) return x * temp;
        return temp;
    }
}