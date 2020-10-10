class Solution {
    //Runtime: 2 ms, faster than 99.56%
    //Memory Usage: 40 MB, less than 16.64%
    public int maxAreaOfIsland(int[][] grid) {
        int ROW = grid.length;
        int COL = grid[0].length;
        int result = 0;
        for(int i = 0; i < ROW; i++){
            for(int j = 0; j < COL; j++){
                if(grid[i][j] == 1){
                    int area = dfs(grid, i, j);
                    result = Math.max(area, result);
                }

            }
        }
        return result;
    }
    private int dfs(int[][] grid, int row, int col){
        int area = 0;
        int ROW = grid.length;
        int COL = grid[0].length;
        if(row < 0 || col < 0 || row > ROW-1 || col > COL-1 ||
           grid[row][col] == 0) return 0;
        else area++;

        grid[row][col] = 0;
        return area +
            dfs(grid, row+1,col) +
            dfs(grid, row, col+1) +
            dfs(grid, row-1, col) +
            dfs(grid, row, col-1);
    }
}
