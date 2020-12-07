class Solution {
    private boolean isSubstr(String sub, String target){
        int i = 0;
        int j = 0;
        while(i < sub.length() && j < target.length()){
            if(sub.charAt(i) == target.charAt(j++)){
                i++;
            }
        }
        return i == sub.length();
    }
    // Runtime: 23 ms, faster than 51.85%
    // Memory Usage: 40.3 MB, less than 76.20%
    public String findLongestWord(String s, List<String> d) {
        String result = "";
        for(String str: d){
            if(str.length() > result.length()
               || (str.length() == result.length() && str.compareTo(result) < 0)){
                if(isSubstr(str, s)){
                    result = str;
                }
            }
        }
        return result;
    }
}
