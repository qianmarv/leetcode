import java.util.*;

class Solution {
    //Runtime: 11 ms, faster than 76.48%
    //Memory Usage: 41.7 MB, less than 15.17%
    public int[][] allCellsDistOrder1(int R, int C, int r0, int c0) {
        int[][] ret = new int[R*C][2];
        for(int i = 0; i < R; i++){
            for(int j = 0; j < C; j++){
                ret[i*C+j][0] = i;
                ret[i*C+j][1] = j;
            }
        }
        Arrays.sort(ret, new Comparator<int[]>(){
            @Override
            public int compare(int[] a, int[] b){
                int distanceA = Math.abs(a[0] - r0) + Math.abs(a[1] - c0);
                int distanceB = Math.abs(b[0] - r0) + Math.abs(b[1] - c0);
                return distanceA - distanceB;
            }
        });
        return ret;
    }
    //Runtime: 10 ms, faster than 78.76%
    //Memory Usage: 40.8 MB, less than 89.23%
    public int[][] allCellsDistOrder(int R, int C, int r0, int c0) {
        int[][] ret = new int[R*C][2];
        boolean[][] his = new boolean[R][C];
        int index = 0;
        int[][] direction = new int[][]{{-1,0},{0,1},{1,0},{0,-1}};
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{r0, c0});
        ret[index][0] = r0;
        ret[index][1] = c0;
        index++;
        his[r0][c0] = true;
        while(!q.isEmpty()){
            int size = q.size();
            while(size-- > 0){
                int[] pos = q.poll();


                for(int[] d: direction){
                    int[] neighbor = new int[2];
                    neighbor[0] = pos[0] + d[0];
                    neighbor[1] = pos[1] + d[1];
                    //check valid
                    if(neighbor[0] >= 0 && neighbor[0] < R &&
                       neighbor[1] >= 0 && neighbor[1] < C &&
                       !his[neighbor[0]][neighbor[1]]){
                        q.add(neighbor);
                        ret[index][0] = neighbor[0];
                        ret[index][1] = neighbor[1];
                        his[neighbor[0]][neighbor[1]] = true;
                        index++;
                    }
                }
            }
        }
        return ret;
    }
    public static void main(String[] args) {
        Solution so = new Solution();
        System.out.println(Arrays.toString(so.allCellsDistOrder(2,2,0,1)));
    }
}
