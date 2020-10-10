class Solution {
    private int M;
    private int N;
    //Runtime: 1 ms, faster than 99.84%
    //Memory Usage: 40.8 MB, less than 6.18%
    public void solve(char[][] board) {
        if(board == null || board.length < 2 || board[0].length < 2) return;
        this.M = board.length;
        this.N = board[0].length;

        for(int i = 0; i < M; i++){
            dfs(board, i, 0);
            dfs(board, i, N-1);
        }

        for(int j = 0; j < N; j++){
            dfs(board, 0, j);
            dfs(board, M-1, j);
        }
        for(int i = 0; i < M; i++){
            for(int j = 0; j < N; j++){
                if(board[i][j] == 'T'){
                    board[i][j] = 'O';
                }else if(board[i][j] == 'O'){
                    board[i][j] = 'X';
                }
            }
        }
    }

    private void dfs(char[][] board, int i, int j){
        if(i < 0 || j < 0 || i > M-1 || j > N-1 || board[i][j] != 'O') return;
        board[i][j] = 'T';
        dfs(board, i-1, j);
        dfs(board, i, j+1);
        dfs(board, i+1, j);
        dfs(board, i, j-1);
    }
}
