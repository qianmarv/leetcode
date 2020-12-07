class Solution {
    //Runtime: 3 ms, faster than 95.67%
    //Memory Usage: 38.8 MB, less than 91.65%
    public String removeKdigits(String num, int k) {
        StringBuilder sb = new StringBuilder(num);
        while(k-- > 0){
            if(sb.length() < 2) return "0";
            int i = 0;
            while(++i < sb.length()){
                if(sb.charAt(i) < sb.charAt(i-1)){
                    break;
                };
            }
            sb.deleteCharAt(i-1);
            while(sb.length() > 0 && sb.charAt(0) == '0'){
                sb.deleteCharAt(0);
            }
        }
        return sb.length() == 0 ? "0" : sb.toString();
    }
}
