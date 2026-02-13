class Solution {
    public int commonFactors(int a, int b) {
        while(b != 0){
            int temp = b;
            b = a % b;
            a = temp;
        }
        int gcd = a;
        int cnt = 0;
        for(int i=1; i*i<=gcd; i++){
            if(gcd % i == 0) {
                if(i * i == gcd)
                cnt++;
                else
                cnt += 2;
            }
        }
        return cnt;
    }
}