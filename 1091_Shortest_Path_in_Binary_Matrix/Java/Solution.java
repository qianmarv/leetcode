class Solution {
    //Runtime: 28 ms, faster than 26.02%
    //Memory Usage: 40.8 MB, less than 60.99%
    public int shortestPathBinaryMatrix(int[][] grid) {
        int N = grid.length;
        int count = 0;

        Queue<Pair<Integer, Integer>> queue = new LinkedList<>();
        queue.offer(new Pair<>(0,0));

        int[][] directions = new int[][]{
            {-1,-1},{-1,0},{-1,1},
            {0,-1},{0,1},
            {1,-1},{1,0},{1,1}
        };

        while(!queue.isEmpty()){
            int size = queue.size();
            count++;
            while(size-- > 0){
                Pair<Integer, Integer> pos = queue.poll();

                int i = pos.getKey(), j = pos.getValue();

                if(grid[i][j] == 1) continue;

                if(i == N-1 && j == N-1) return count;

                grid[i][j] = 1;

                for(int[] direction: directions){
                    int m = direction[0] + i;
                    int n = direction[1] + j;
                    if(m >= 0 && m < N &&
                       n >= 0 && n < N ){
                        queue.add(new Pair<>(m,n));
                    }
                }
            }
        }
        return -1;
    }
}
