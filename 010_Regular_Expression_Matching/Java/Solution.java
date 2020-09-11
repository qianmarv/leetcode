class Solution{
    private boolean helper(int i, int j, String s, String p){
        return i >= 0 && j >= 0 &&  (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.');
    }
    public boolean isMatch(String s, String p){
        if(s == null || p == null) return false;

        boolean[][] dp = new boolean[s.length()+1][p.length()+1];
        dp[0][0] = true; // empty string matches empty pattern

        // matches the pattern for empty string and pattern like 'a*b*c*'
        for(int j = 1; j < p.length(); j+=2){
            if(p.charAt(j) == '*' && dp[0][j-1]){
                dp[0][j+1] = true;
            }
        }

        for(int i = 0; i < s.length(); i++){
            for(int j = 0; j < p.length(); j++){
                if(helper(i,j,s,p)){
                    dp[i+1][j+1] = dp[i][j];
                }else{
                    if(p.charAt(j) == '*'){
                        // * repeat 0, 1, many times
                        //TODO if first char is * might be exception - outbound
                        if(!helper(i,j-1,s,p)){
                            dp[i+1][j+1] = dp[i+1][j-1]; // repeat zero
                        }else{
                            dp[i+1][j+1] = dp[i+1][j-1]|| dp[i][j-1] || dp[i][j+1]; // repeat once or more
                        }
                    }
                }
            }
        }
        return dp[s.length()][p.length()];
    }
    public static void main(String[] argv){
        Solution o = new Solution();
        System.out.println("Match: " + o.isMatch(argv[0], argv[1]));
    }
}
