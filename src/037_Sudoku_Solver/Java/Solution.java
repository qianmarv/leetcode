class Solution{
    private char[][] board;
    private boolean[][] usedInRow = new boolean[9][10];
    private boolean[][] usedInCol = new boolean[9][10];
    private boolean[][] usedInCub = new boolean[9][10];
    //Runtime: 3 ms, faster than 94.75%
    //Memory Usage: 38.9 MB, less than 9.50%
    public void solveSudoku(char[][] board){
        this.board = board;
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                if(board[i][j] == '.') continue;
                int n = board[i][j] - '0';
                usedInRow[i][n] = true;
                usedInCol[j][n] = true;
                usedInCub[cubeIndex(i,j)][n] = true;
            }
        }
        backtracking(0,0);
    }

    private boolean backtracking(int row, int col){
        while(row < 9 && board[row][col] != '.'){
            row = col == 8 ? row + 1: row;
            col = col == 8 ? 0: col + 1;
        }

        if(row == 9) return true;
        int cub = cubeIndex(row, col);
        for(int i = 1; i <= 9; i++){
            if(usedInRow[row][i] ||
               usedInCol[col][i] ||
               usedInCub[cub][i]) continue;
            board[row][col] = (char)('0' + i);
            usedInRow[row][i] = usedInCol[col][i] = usedInCub[cub][i] = true;
            if(backtracking(row, col)) return true;
            board[row][col] = '.';
            usedInRow[row][i] = usedInCol[col][i] = usedInCub[cub][i] = false;
        }
    }

    private int cubeIndex(int row, int col){
        int m = row / 3;
        int n = col / 3;
        return m * 3 + n;
    }
}
