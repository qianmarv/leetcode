class Solution{
    //Runtime: 0 ms, faster than 100.00%
    //Memory Usage: 37.4 MB, less than 51.76%
    public int numberOfArithmeticSlices(int[] A){
        int dp = 0;
        int n  = 3;
        int result = 0;

        if(A.length < 3) return 0;

        for(int i = 2; i < A.length; i++){
           if(A[i-1] - A[i-2] == A[i] - A[i-1]){
               dp = n - 2 + dp;
               n++;
           }else{
               result += dp;
               //Initialize
               dp = 0;
               n  = 3;
           }
        }
        result += dp;
        return result;
    }
}
