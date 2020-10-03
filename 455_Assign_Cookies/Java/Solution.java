import java.util.Arrays;
class Solution {
    //Runtime: 8 ms, faster than 38.33%
    //Memory Usage: 39.9 MB, less than 89.58%
    public int findContentChildren(int[] g, int[] s){
        Arrays.sort(g);
        Arrays.sort(s);
        int result = 0;
        int j = 0;
        for(int i = 0; i < g.length; i++){
            while(j < s.length){
                if(s[j++] >= g[i]){
                    result++;
                    break;
                }
            }
        }
        return result;
    }
}
