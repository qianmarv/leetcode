class Solution {
    //Runtime: 0 ms, faster than 100%
    //Memory Usage: 38.6 MB, less than 78.41%
    public int minCostClimbingStairs(int[] cost) {
        int dp_pre1 = 0, dp_pre2 = 0;
        int dp_curr = 0;
        for(int i = 2; i <= cost.length; i++){
            dp_curr = Math.min(dp_pre1 + cost[i-1], dp_pre2+cost[i-2]);
            dp_pre2 = dp_pre1;
            dp_pre1 = dp_curr;
        }
        return dp_curr;
    }
}
