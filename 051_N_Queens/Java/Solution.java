import java.util.*;
class Solution {
    private boolean[] QInV;
    private boolean[] QInL; // Top Left
    private boolean[] QInR; // Top Right
    private int N;
    //Runtime: 2 ms, faster than 94.51%
    //Memory Usage: 39.1 MB, less than 5.47%
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ret = new ArrayList<>();
        List<String> tempSolution = new ArrayList<>();

        N = n;

        QInV = new boolean[N];
        QInL = new boolean[2*N-1];
        QInR = new boolean[2*N-1];

        backtracking(ret, tempSolution,  0);
        return ret;
    }
    private void backtracking(List<List<String>> ret, List<String> tempSolution, int row){
        if(row == N){
            ret.add(new ArrayList<String>(tempSolution));
            return;
        }
        char[] qInRow = new char[N];
        for(int i = 0; i < N; i++){
            int idxL = row + i;
            int idxR = N - 1 - ( row - i);
            if(QInV[i] || QInL[idxL] || QInR[idxR]){
                qInRow[i] = '.';
                continue;
            };
            qInRow[i] = 'Q';
            for(int j = N - 1; j > i; j--){
                qInRow[j] = '.';
            }
            QInV[i] = true;
            QInL[idxL] = true;
            QInR[idxR] = true;
            tempSolution.add(String.valueOf(qInRow));

            backtracking(ret, tempSolution, row+1);

            qInRow[i] = '.';
            QInV[i] = false;
            if(idxL >= 0 && idxL < QInL.length) QInL[idxL] = false;
            if(idxR >= 0 && idxR < QInR.length) QInR[idxR] = false;

            tempSolution.remove(tempSolution.size()-1);
        }
    }

    public static void main(String[] args) {
        Solution so = new Solution();
        int n = Integer.valueOf(args[0]);
        List<List<String>> ways = so.solveNQueens(n);
        for(List<String> way: ways){
            System.out.println("===Solution===");
            System.out.println(way.toString());
        }
    }
}
