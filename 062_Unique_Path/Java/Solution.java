class Solution{
    //Runtime: 0 ms, faster than 100.00% of Java online submissions for Unique Paths.
    public int uniquePaths(int m, int n) {
       int[][] dp = new int[m][n];
       dp[0][0] = 1;
       for(int i = 0; i < m; i++){
           for(int j = 0; j < n; j++){
               int up   ;
               int left ;

               if(i == 0){
                  up = 0;
               }else{
                   up = dp[i-1][j];
               }

               if(j == 0){
                   left = 0;
               }else{
                   left = dp[i][j-1];
               }

               dp[i][j] += left + up;
           }
       }
       return dp[m-1][n-1];
    }
}
