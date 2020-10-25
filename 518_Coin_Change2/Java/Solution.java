class Solution {
    //Runtime: 2 ms, faster than 100.00%
    //Memory Usage: 36.3 MB, less than 7.26%
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount+1];
        dp[0] = 1;
        for(int coin: coins){
            for(int i = coin; i <= amount; i++){
                dp[i] += dp[i-coin];
            }
        }
        return dp[amount];
    }
}
