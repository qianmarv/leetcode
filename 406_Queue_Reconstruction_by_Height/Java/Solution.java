import java.util.Arrays;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.List;
import java.util.Comparator;

class Solution {
    // With LinkedList
    //Runtime: 10 ms, faster than 36.64%
    //Memory Usage: 52.4 MB, less than 15.55%
    //
    // With ArrayList
    //Runtime: 5 ms, faster than 99.06%
    //Memory Usage: 40.2 MB, less than 75.33%
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, new Comparator<int[]>(){
                @Override
                public int compare(int[] o1, int[] o2){
                    if(o1[0] < o2[0]){
                        return 1;
                    }else if(o1[0] > o2[0]){
                        return -1;
                    }else{
                        return o1[1] - o2[1];
                    }
                }
            });
        List<int []> orderedPeople = new ArrayList<>();
        for(int[] p: people){
            orderedPeople.add(p[1], p);
        }
        return orderedPeople.toArray(new int[people.length][]);
    }
    public static void main(String[] args) {
        Solution so = new Solution();
        int[][] arr = new int[][]{{7,0},{4,4},{7,1},{5,0},{6,1},{5,2}};
        arr = so.reconstructQueue(arr);
        for(int[] ar: arr){
            System.out.println(Arrays.toString(ar));
        }
    }
}
