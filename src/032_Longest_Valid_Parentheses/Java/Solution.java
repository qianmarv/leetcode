import java.util.Arrays;
import java.util.Stack;

class Solution{
    // Dynamic Programming: Runtime: 2 ms, faster than 75.67% of Java online submissions for Longest Valid Parentheses.
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

    // Brute Force: Time Limit Exceeded
    public int bfLVP(String s){
        int result = 0;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == ')') continue;
            for(int j = i+1; j < s.length(); j++){
                if(s.charAt(j) == ')'){ // Check if Valid
                    int unclosedParen = 0;
                    for(int m = i; m <= j; m++){
                        if(s.charAt(m) == '('){
                            unclosedParen++;
                        }else{
                            unclosedParen--;
                            if(unclosedParen < 0){
                                break;
                            }
                        }
                    }
                    if(unclosedParen == 0) {
                        result = Math.max(result, (j-i+1));
                    }
                }
            }
        }
        return result;
    }

    // Stack: Runtime: 7 ms, faster than 15.96% of Java online submissions for Longest Valid Parentheses.
    public int stackLVP(String s){
        Stack<Integer> parens = new Stack<Integer>();
        int result = 0;
        parens.push(-1);
        for(int i = 0; i < s.length(); i++){
           if(s.charAt(i) == '(') {
               parens.push(i);
           }else{
               if(!parens.empty()){
                   int currIndex = parens.pop();
                   if(currIndex >= 0 && s.charAt(currIndex) == '('){
                       result = Math.max(result, i - parens.peek());
                   }
               }
               if(parens.empty()){
                   parens.push(i);
               }
           }
        }
        return result;
    }

    public static void main(String[] args){
        Solution sol = new Solution();

        System.out.println("Dynamic Programming:" + Integer.toString(sol.longestValidParentheses(args[0])));
        System.out.println("Brute Force:        " + Integer.toString(sol.bfLVP(args[0])));
        System.out.println("Stack:              " + Integer.toString(sol.stackLVP(args[0])));
    }
}
