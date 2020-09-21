class Solution {
    private boolean validPalindrome(String s, int start, int end){
        int i = start;
        int j = end;
        while( i <= j){
            if(s.charAt(i++) != s.charAt(j--)){
                return false;
            }
        }
        return true;
    }
    // Runtime: 6 ms, faster than 82.85%
    // Memory Usage: 39.9 MB, less than 73.06%
    public boolean validPalindrome(String s) {
        int i = 0;
        int j = s.length()-1;
        while(i <= j){
            if(s.charAt(i++) != s.charAt(j--)){
                return validPalindrome(s,i,j+1) || validPalindrome(s,i-1,j);
            }
        }
        return true;
    }
}
