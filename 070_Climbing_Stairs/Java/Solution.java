class Solution{
    public int climbStairs(int n) {
        int prev2 = 0;
        int prev1 = 1;
        int result = 0;
        for(int i = 1; i <= n; i++){
           result = prev2 + prev1;
           prev2  = prev1;
           prev1  = result;
        }
        return result;
    }
}
