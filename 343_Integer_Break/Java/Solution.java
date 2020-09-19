class Solution{
    //Runtime: 0 ms, faster than 100.00%
    //Memory Usage: 36.3 MB, less than 51.21%
    public int integerBreak(int n){
        int[] dp = new int[n+1];
        // n  always > 2;
        if(n == 2) return 1;
        if(n == 3) return 2;
        
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;
        for(int i = 4; i <= n; i++){
            for(int j = 1; j < i - 1; j++){
                dp[i] = Math.max(dp[i], dp[j] * dp[i-j]);
            }
        }
        return dp[n];
    }

    public static void main(String[] args){
        Solution so = new Solution();
        int n = Integer.parseInt(args[0]);
        System.out.printf("Integer %d %d", n, so.integerBreak(n));
    }
}
