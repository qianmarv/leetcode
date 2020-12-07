class Solution {
    // Runtime: 13 ms, faster than 53.32%
    // Memory Usage: 38.7 MB, less than 5.55%
    public int coinChange(int[] coins, int amount) {
        if(amount == 0) return 0;
        int[] dp = new int[amount+1];
        for(int coin: coins){
            for(int i = coin; i <= amount; i++){
                if(i == coin){
                    dp[i] = 1;
                }else if(dp[i] == 0 && dp[i-coin] != 0){
                    dp[i] = dp[i-coin] + 1;
                }else if(dp[i-coin] != 0){
                    dp[i] = Math.min(dp[i], dp[i-coin]+1);
                }
            }
        }
        return dp[amount] == 0 ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        int[] coins = new int[]{1, 2, 5};
        Solution so = new Solution();
        System.out.println("Max=" + so.coinChange(coins, 11));
    }
}
