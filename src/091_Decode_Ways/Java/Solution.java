class Solution {
    //Runtime: 0 ms, faster than 100.00%
    //Memory Usage: 37.8 MB, less than 81.27% 
    public int numDecodings(String s) {
        int[] dp = new int[3];
        if(s == null || s.length() == 0) return 0;
        if(s.length() == 1) return s.charAt(0) == '0' ? 0 : 1;
        if(s.length() > 1 && s.charAt(0) == '0') return 0;

        for(int i = 1; i < s.length(); i++){
            char prev = s.charAt(i-1);
            char curr = s.charAt(i);

            if(prev == '1' || (prev == '2' && curr <= '6')){
                dp[0] = ( dp[2] == 0 ? 1 : dp[2] );
            }else{
                if(curr == '0') return 0;
                dp[0] = 0;
            }
            if(curr != '0') dp[0] += dp[1] == 0 ? 1 : dp[1];
            
            dp[2] = dp[1];
            dp[1] = dp[0];
        }
        return dp[0];
    }
    public static void main(String[] args){
        Solution so = new Solution();
        System.out.println(so.numDecodings(args[0]));
    }
}
