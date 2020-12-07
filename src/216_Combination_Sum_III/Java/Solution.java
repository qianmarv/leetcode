class Solution {
    //Runtime: 0 ms, faster than 100.00%
    //Memory Usage: 36.5 MB, less than 27.29%
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ret = new ArrayList<>();
        List<Integer> prefix    = new ArrayList<>();
        backtracking(k, n, ret, prefix, 1);
        return ret;
    }

    private void backtracking(int k, int n, List<List<Integer>> ret, List<Integer> prefix, int curr){
        if(prefix.size() == k){
            if(n == 0){
                ret.add(new ArrayList<>(prefix));
            }
            return;
        };

        for(int i = curr; i <= 9; i++){
            int rest = n - i;
            if(rest >= i+1){
                prefix.add(i);
                backtracking(k, rest, ret, prefix, i+1);
                prefix.remove(prefix.size()-1);
            }
        }
    }
}
