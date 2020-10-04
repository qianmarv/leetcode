class Solution {
    //Runtime: 14 ms, faster than 99.86%
    //Memory Usage: 46.9 MB, less than 76.87%
    public int findMinArrowShots(int[][] points) {
        if(points.length == 0) return 0;
        Arrays.sort(points, new Comparator<int[]>(){
                @Override
                public int compare(int[] o1, int[] o2){
                    if(o1[1] < o2[1])
                        return -1;
                    else if(o1[1] > o2[1])
                        return 1;
                    else
                        return 0;
                }
            });
        int maxNOI = 1;
        int endX   = points[0][1];
        for(int i = 1; i < points.length; i++){
            if(endX < points[i][0]){
                maxNOI++;
                endX = points[i][1];
            }
        }
        return maxNOI;
    }
}
