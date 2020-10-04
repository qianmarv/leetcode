class Solution {
    //Runtime: 0 ms, faster than 100.00%
    //Memory Usage: 36.7 MB, less than 99.23%
    public boolean isSubsequence(String s, String t) {
        int i = -1;
        int j = -1;
        while(++i < s.length() && ++j < t.length()){
            char c = s.charAt(i);
            while(j < t.length() && t.charAt(j) != c) j++;
        }
        if(i == s.length() && j < t.length())
            return true;
        else
            return false;
    }
    public static void main(String[] args) {
        String s = "axc";
        String t = "ahbgdc";
        Solution so = new Solution();
        System.out.println(so.isSubsequence(s,t));
    }
}
