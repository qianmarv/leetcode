class Solution {
    private StringBuilder helper(StringBuilder sb, char c, int times){
        for(int i = 0; i < times; i++){
            sb.insert(0, c);
        }
        return sb;
    }
    private char getRomanOne(int factor){
        char result = 'Z';
        switch(factor){
        case 1:
            result = 'I';
            break;
        case 10:
            result = 'X';
            break;
        case 100:
            result = 'C';
            break;
        case 1000:
            result = 'M';
            break;
        default:
            break;
        }
        return result;
    }
    private char getRomanFive(int factor){
        char result = 'Z';
        switch(factor){
        case 1:
            result = 'V';
            break;
        case 10:
            result = 'L';
            break;
        case 100:
            result = 'D';
            break;
        default:
            break;
        }
        return result;
    }
    //Runtime: 4 ms, faster than 92.30%
    //Memory Usage: 39.1 MB, less than 84.26%
    public String intToRoman(int num) {
        //Input is between 1 to 3999
        StringBuilder result = new StringBuilder();
        int ret    = num;
        int factor = 1;
        int rem    = 0;
        while(ret > 0){
            rem = ret % 10;
            
            char one  = getRomanOne(factor);
            char five = getRomanFive(factor);
            
            if(rem >= 1 && rem < 4){
                result = helper(result, one, rem);
            }else if(rem == 4){
                result = helper(result, five, 1) ;
                result = helper(result, one, 1);
            }else if(rem >= 5 && rem < 9){
                int left = rem - 5;
                result = helper(result, one, left);
                result = helper(result, five, 1);
            }else if(rem == 9){
                result = helper(result, getRomanOne(factor*10), 1);
                result = helper(result, one, 1);
            }
            ret /= 10;
            factor = factor * 10;
        }
        return result.toString();
    }
    // One solution from Forum for Reference
    // Runtime: 14 ms, faster than 25.08%
    // Memory Usage: 40 MB, less than 39.42%
    public String intToRoman_AA(int num) {
        String M[] = {"", "M", "MM", "MMM"};
        String C[] = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        String X[] = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        String I[] = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
        return M[num/1000] + C[(num%1000)/100] + X[(num%100)/10] + I[num%10];
    }
    public static void main(String[] args){
        Solution so = new Solution();
        int num = Integer.parseInt(args[0]);
        System.out.printf("Number %d with Roman Numeral: %s", num, so.intToRoman(num));
    }
}
