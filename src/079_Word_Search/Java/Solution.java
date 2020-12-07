class Solution {
    private int M;
    private int N;
    private static int[][] directions = new int[][]{{-1,0},{1,0},{0,-1},{0,1}};
    //Runtime: 5 ms, faster than 82.67%
    //Memory Usage: 41 MB, less than 6.93%
    public boolean exist(char[][] board, String word) {
        this.M = board.length;
        this.N = board[0].length;
        boolean[][] visited = new boolean[M][N];

        for(int i = 0; i < M; i++){
            for(int j = 0; j < N; j++){
                if(word.charAt(0) == board[i][j]){
                    if(backtrack(board, visited, i, j, word, 1)) return true;
                }
            }
        }
        return false;
    }

    public boolean backtrack(char[][] board, boolean[][] visited, int i, int j, String word, int index){
        if(index  >= word.length()) return true;
        char c = word.charAt(index);
        visited[i][j] = true;

        for(int[] direction: directions){
            int m = i + direction[0];
            int n = j + direction[1];
            if(m < 0 || n < 0 || m >= M || n >= N || visited[m][n]) continue;
            if(board[m][n] == c){
                if(backtrack(board, visited, m, n, word, index+1)) return true;
            }
        }
        visited[i][j] = false;
        return false;
    }

    public static void main(String[] args) {
        Solution so = new Solution();
        String str = args[0];
        char[][] board = new char[][]{{'A','B'},
                                      {'S','F'}};
        // char[][] board = new char[][]{{'A','B','C','E'},
        //                               {'S','F','C','S'},
        //                               {'A','D','E','E'}};
        System.out.println(so.exist(board, str));
    }
}
