class Solution {
    private int helper(char c){
        int result = 0;
        switch(c){
        case 'I':
            result = 1;
            break;
        case 'V':
            result = 5;
            break;
        case 'X':
            result = 10;
            break;
        case 'L':
            result = 50;
            break;
        case 'C':
            result = 100;
            break;
        case 'D':
            result = 500;
            break;
        case 'M':
            result = 1000;
            break;
        default:
            break;
        }
        return result;
    }
    //Runtime: 3 ms, faster than 100.00%
    //Memory Usage: 39.6 MB, less than 84.93%
    public int romanToInt(String s) {
        int result = 0;
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            int factor = helper(c);
            if(i+1 < s.length()){
                int nextFactor = helper(s.charAt(i+1));
                if(factor < nextFactor){
                    result += nextFactor - factor;
                    i++;
                    continue;
                }
            }
            result += factor;
        }
        return result;
    }

    public static void main(String[] args){
        Solution so = new Solution();
        String roman = args[0];
        System.out.printf("Roman: %s -> %d" , roman, so.romanToInt(roman));
    }
}
