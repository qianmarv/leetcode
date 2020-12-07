class Solution {
    //Runtime: 0 ms, faster than 100.00%
    //Memory Usage: 36.7 MB, less than 64.15%
    public int matrixScore(int[][] A) {
        int     ROW = A.length;
        int     COL = A[0].length;
        int     ret = 0;

        ret = ROW * (1 << (COL - 1));

        for(int c = 1; c < COL; c++){
            int nOnes = 0;
            for(int r = 0; r < ROW; r++){
                if(A[r][0] == 1){
                    nOnes += A[r][c];
                }else{
                    nOnes += 1 - A[r][c];
                }
            }
            int num = Math.max(nOnes, ROW - nOnes);
            ret += num * (1 << (COL - c - 1));
        }
        return ret;
    }
}
