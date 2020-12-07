class Solution {
    //Runtime: 6 ms, faster than 63.94%
    //Memory Usage: 40.6 MB, less than 8.63%
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length()+1];
        dp[0] = true;
        for(int i = 1; i <= s.length(); i++){
            for(String word: wordDict){
                int len = word.length();
                if(i >= len && word.equals(s.substring(i-len,i))){
                    dp[i] = dp[i] || dp[i-len];
                }
            }
        }
        return dp[s.length()];
    }
}
