class Solution {
    private int [][] dp;
    //Runtime: 1 ms, faster than 99.12% of Java online submissions for Minimum Path Sum.
    public int minPathSum(int[][] grid) {
        int nRows = grid.length;
        int nCols = grid[0].length;
        dp = new int[nRows][nCols];
        for(int i = 0; i < nRows; i++){
            for(int j = 0; j < nCols; j++){
                dp[i][j] = -1;
            }
        }

        return _minPathSum(nRows-1,nCols-1,grid);
    }

    private int _minPathSum(int row, int col, int[][]grid){
        if(dp[row][col] != -1){
            return dp[row][col];
        }
        int nRows = grid.length;
        int nCols = grid[0].length;
        int min   = 0;

        if(row != 0 && col != 0){
            int toLeft = _minPathSum(row, col-1, grid);
            int toUp   = _minPathSum(row-1, col, grid);
            min = Math.min(toLeft, toUp);
        }else if( col != 0){
            min =  _minPathSum(row, col-1, grid);
        }else if( row != 0 ){
            min =  _minPathSum(row-1, col, grid);
        }
        dp[row][col] = min + grid[row][col];
        return dp[row][col];
    }

    //Runtime: 2 ms, faster than 87.42% of Java online submissions for Minimum Path Sum.
    public mpsDP(int[][] grid){
        int result = 0;
        int nRows = grid.length;
        int nCols = grid[0].length;
        for(int i = 0; i < nRows; i++){
            for(int j = 0; j < nCols; j++){
                int minTop = 0;
                int minLeft = 0;
                if(i == 0 && j == 0){
                    continue;
                }else if(i == 0){
                    grid[i][j] += grid[i][j-1];
                }else if(j == 0){
                    grid[i][j] += grid[i-1][j];
                }else{
                    grid[i][j] += Math.min(grid[i][j-1], grid[i-1][j]) ;
                }
            }
        }
        return grid[nRows-1][nCols-1];
    }
}
