class Solution {
    int M;
    int N;

    private static int[][] directions = new int[][]{{-1,0},{0,1},{1,0},{0,-1}};
    //Runtime: 4 ms, faster than 81.36%
    //Memory Usage: 40.2 MB, less than 14.57%
    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
        List<List<Integer>> result = new ArrayList<>();

        if(matrix == null || matrix.length == 0) return result;
        this.M = matrix.length;
        this.N = matrix[0].length;

        boolean[][] canReachP = new boolean[M][N];
        boolean[][] canReachA = new boolean[M][N];

        for(int i = 0; i < M; i++){
            dfs(matrix, i, 0, canReachP);
            dfs(matrix, i, N-1, canReachA);

        }
        for(int i = 0; i < N; i++){
            dfs(matrix, 0, i, canReachP);
            dfs(matrix, M-1, i, canReachA);
        }

        for(int i = 0; i < M; i++){
            for(int j = 0; j < N; j++){
                if(canReachP[i][j] && canReachA[i][j]){
                    result.add(Arrays.asList(i,j));
                }
            }
        }
        return result;
    }
    private void dfs(int[][] matrix, int i, int j, boolean[][] reach){
        if(reach[i][j]) return;
        reach[i][j] = true;
        
        for(int[] direct: directions){
            int m = i+direct[0], n = j+direct[1];
            if(m < 0 || n < 0 || m > M - 1 || n > N - 1 ||
               matrix[m][n] < matrix[i][j]){
                continue;
            }
            dfs(matrix, m, n, reach);
        }
    }
}
