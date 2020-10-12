import java.util.*;
class Solution {
    //Runtime: 1 ms, faster than 100.00%
    //Memory Usage: 40.3 MB, less than 17.29%
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ret = new ArrayList<>();
        backtrack(n, k, ret, 1, new ArrayList<>());
        return ret;
    }
    private void backtrack(int n, int k, List<List<Integer>> ret, int start, List<Integer> prefix){
        List<Integer> curr = new ArrayList<>(prefix);
        if(k == 0){
            ret.add(curr);
            return;
        }

        for(int i = start; i <= n-k+1; i++){
            prefix.add(i);
            backtrack(n, k-1, ret, i+1, prefix);
            prefix.remove(prefix.size()-1);
        }
    }
    public static void main(String[] args) {
        Solution so = new Solution();
        List<List<Integer>> ret = so.combine(3,2);
        for(List<Integer> l: ret){
            System.out.println(l.toString());
        }
    }
}
