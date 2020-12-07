class Solution {
    int N;
    //Runtime: 0 ms, faster than 100.00%
    //Memory Usage: 39.7 MB, less than 14.89%
    public int findCircleNum(int[][] M) {
        N = M.length;
        int count = 0;
        for(int i = 0; i < N; i++){
            if(M[i][i] == 1){
                count++;
                dfs(M, i);
            }
        }
        return count;
    }
    private void dfs(int[][] M, int p){
        if(M[p][p] == 0) return;
        M[p][p] = 0;
        for(int i = 0; i < N; i++){
            if(M[p][i] == 1){
                dfs(M, i);
            }
        }
    }
}
