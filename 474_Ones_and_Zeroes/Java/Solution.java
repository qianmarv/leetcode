class Solution {
    //Runtime: 32 ms, faster than 90.65%
    //Memory Usage: 38.6 MB, less than 5.21%
    public int findMaxForm(String[] strs, int m, int n) {
        int[][] dp = new int[m+1][n+1];

        for(String s: strs){
            int zeros = 0;
            int ones  = 0;
            for(int i = 0; i < s.length(); i++){
                if(s.charAt(i) == '0'){
                    zeros++;
                }else{
                    ones++;
                }
            }
            for(int i = m; i >= zeros; i--){
                for(int j = n; j >= ones; j--){
                    dp[i][j] = Math.max(dp[i][j], dp[i-zeros][j-ones]+1);
                }
            }
        }
        return dp[m][n];
    }
}
