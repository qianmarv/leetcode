class Solution {
    //Runtime: 1 ms, faster than 100.00%
    //Memory Usage: 39.1 MB, less than 65.56%
    public List<List<Integer>> largeGroupPositions(String s) {
        List<List<Integer>> ret = new ArrayList<>();
        int THR = 3;
        if(s.length() < THR) return ret;

        int si = 0, ei = 1;
        while(ei <= s.length()){
            if(ei == s.length() || s.charAt(si) != s.charAt(ei)){
                if(ei - si >= THR){
                    ret.add(new ArrayList<>(Arrays.asList(si, ei-1)));
                }
                si = ei;
            }
            ei++;
        }
        return ret;
    }
}
