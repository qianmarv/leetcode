class Solution {
    //Runtime: 3 ms, faster than 59.88%
    //Memory Usage: 39.7 MB, less than 11.10%
    public List<List<String>> partition(String s) {
        List<List<String>> ret = new ArrayList<>();
        backtrack(s, ret, new ArrayList<String>());
        return ret;
    }

    private void backtrack(String s, List<List<String>> ret, List<String> prefix){
        if(s.length() == 0){
            ret.add(new ArrayList<String>(prefix));
        }
        for(int i = 0; i < s.length(); i++){
            String s1 = s.substring(0,i+1);
            if(isPalindrome(s1)){
                prefix.add(s1);
                String s2 = s.substring(i+1);
                backtrack(s2, ret, prefix);
                prefix.remove(prefix.size()-1);
            }
        }
    }

    private boolean isPalindrome(String s){
        int i = 0, j = s.length()-1;
        while(i <= j){
            if(s.charAt(i++) != s.charAt(j--)) return false;
        }
        return true;
    }
}
