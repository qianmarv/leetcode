class Solution {
    //Runtime: 8 ms, faster than 92.40%
    //Memory Usage: 43.2 MB, less than 5.07%
    public int longestCommonSubsequence(String text1, String text2) {
        int M = text1.length();
        int N = text2.length();
        int[][] dp = new int[M+1][N+1];
        dp[0][0] = dp[0][1] = dp[1][0] = 0;
        for(int i = 0; i < M; i++){
            for(int j = 0; j < N; j++){
                if(text1.charAt(i) == text2.charAt(j)){
                    dp[i+1][j+1] = dp[i][j] + 1;
                }else{
                    dp[i+1][j+1] = Math.max(dp[i+1][j], dp[i][j+1]);
                }
            }
        }
        return dp[M][N];
    }
}
