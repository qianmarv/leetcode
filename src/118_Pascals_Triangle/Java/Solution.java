class Solution {
    //Runtime: 0 ms, faster than 100.00%
    //Memory Usage: 36.8 MB, less than 74.56%
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ret = new ArrayList<>();
        for(int i = 0; i < numRows; i++){
            List<Integer> row = new ArrayList<>();
            row.add(1);
            for(int j = 1; j <= i; j++){
                List<Integer> lastRow = ret.get(i-1);
                int l = lastRow.get(j-1);
                int r = j == i ? 0 : lastRow.get(j);
                row.add(l + r);
            }
            ret.add(row);
        }
        return ret;
    }
}
