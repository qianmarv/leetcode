class Solution {
    //Runtime: 1 ms, faster than 88.03%
    //Memory Usage: 36.3 MB, less than 13.68%
    public String convertToBase7(int num) {
        if(num == 0) return "0";
        String sign = "";
        if(num < 0){
            sign = "-";
            num *= -1;
        }

        StringBuilder sb = new StringBuilder();
        int v = num;
        while(v != 0){
            int r = v % 7;
            sb.insert(0,Integer.toString(r));
            v /= 7;
        }
        return sign + sb.toString();
    }
}
