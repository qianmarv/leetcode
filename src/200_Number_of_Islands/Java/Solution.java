class Solution {
    private int ROW;
    private int COL;
    //Runtime: 1 ms, faster than 99.97%
    //Memory Usage: 41.4 MB, less than 18.00%
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0) return 0;

        int result = 0;
        ROW = grid.length;
        COL = grid[0].length;
        for(int i = 0; i < ROW; i++){
            for(int j = 0; j < COL; j++){
                if(grid[i][j] == '1'){
                    result++;
                    dfsAndSink(grid, i, j);
                }
            }
        }
        return result;
    }

    private void dfsAndSink(char[][] grid, int i, int j){
        if(i < 0 || j < 0 || i > ROW - 1 || j > COL - 1 ||
          grid[i][j] == '0'){
            return;
        }
        grid[i][j] = '0';
        dfsAndSink(grid,i-1,j);
        dfsAndSink(grid,i,j+1);
        dfsAndSink(grid,i+1,j);
        dfsAndSink(grid,i,j-1);
    }
}
