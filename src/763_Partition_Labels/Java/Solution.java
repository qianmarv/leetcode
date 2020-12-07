import java.util.*;
class Solution {
    //Runtime: 3 ms, faster than 83.23%
    //Memory Usage: 37.9 MB, less than 84.87%
    public List<Integer> partitionLabels(String S) {
        List<Integer> result = new ArrayList<>();
        int lo = 0;
        int hi;
        int[] lastIndexOfChar = new int[26];
        for(int i = 0; i < S.length(); i++){
            lastIndexOfChar[charToIndex(S.charAt(i))] = i;
        }
        while(lo < S.length()){
            char c = S.charAt(lo);
            hi = S.lastIndexOf(c);

            for(int i = lo+1; i <= hi; i++){
                char subC  = S.charAt(i);
                //int  subHi = S.lastIndexOf(subC);
                int subHi = lastIndexOfChar[charToIndex(subC)];
                hi = Math.max(subHi, hi);
            }

            result.add(hi-lo+1);
            lo = hi+1;
        }
        return result;
    }
    private int charToIndex(char c){
        return c - 'a';
    }
}
