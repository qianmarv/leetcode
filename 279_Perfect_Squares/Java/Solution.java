import java.util.Arrays;
class Solution{
    //Runtime: 49 ms, faster than 48.56%
    //Memory Usage: 38.9 MB, less than 64.50%
    //Runtime: 34 ms, faster than 62.72%
    //Memory Usage: 38.8 MB, less than 71.88%
    //Runtime: 32 ms, faster than 75.41%
    //Memory Usage: 38.7 MB, less than 76.23%
    public int numSquares(int n){
        var dp = new int[n+1];
        dp[1] = 1;
        //TODO need initialize dp[n] to zero?
        for(int i = 2; i <= n; i++){
            dp[i] = dp[i-1]+1;
            for(int j = 2; true; j++){
                int t = j * j;
                //if j is perfect square number
                if(t > i){
                    break;
                }else{
                    dp[i] = Math.min(dp[i], dp[i-t]+1);
                }
            }
        }
        return dp[n];
    }
    public static void main(String[] args){
        Solution so = new Solution();
        int n = Integer.parseInt(args[0]);
        System.out.printf("Given N=%d, Least number of PS=%d.", n, so.numSquares(n));
    }
}
