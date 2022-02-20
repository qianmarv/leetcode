class Solution{
    public int myAtoi(String str){
        int result    = 0;
        boolean found = false;
        int factor    = 1;
        for(int i = 0; i < str.length(); i++){
            char c = str.charAt(i);
            if(!found && c == ' '){
                continue;
            }else if(!found && (c == '-' || c == '+' || (c >= '0' && c <= '9'))){
                found = true;
                if(c >= '0' && c <= '9'){
                    i--;
                }else{
                    if(c == '-'){
                        factor = -1;
                    }
                }
            }else if(found && c >= '0' && c <= '9'){
                // handle digits
                int digit = Integer.valueOf(c) - Integer.valueOf('0');

                if(result  > Integer.MAX_VALUE/10 || (result == Integer.MAX_VALUE/10 && digit > 7)){
                    if(factor == 1){
                        return Integer.MAX_VALUE;
                    }else{
                        return Integer.MIN_VALUE;
                    }
                }
                result = result * 10 + digit;
                //handle overflow

            }else{
                break;
            }
        }
        return result*factor;
    }
    public static void main(String[] argv){
        Solution sol = new Solution();
        System.out.println(sol.myAtoi(argv[0]));
    }
}
