import java.util.Arrays;

class Solution{
    // Dynamic Programming
    public int longestValidParentheses(String s) {
        int[] dp = new int[s.length()+1];

        for(int i = 0; i <= s.length(); i++){
            dp[i] = 0;
        }

        int result = 0;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == ')'){
                int left = i - dp[i]-1;
                if(left >= 0 && s.charAt(left) == '('){
                    dp[i+1] = 2 + dp[i];
                    if(left-1>=0){
                        dp[i+1] += dp[left];
                    }
                }
                result = Math.max(result, dp[i+1]);
            }
        }
        return result;
    }

    public static void main(String[] args){
        Solution sol = new Solution();

        System.out.println(Integer.toString(sol.longestValidParentheses(args[0])));
    }
}
