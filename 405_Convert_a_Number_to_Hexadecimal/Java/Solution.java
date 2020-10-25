class Solution {
    // Runtime: 0 ms, faster than 100.00%
    // Memory Usage: 36.4 MB, less than 10.81%
    public String toHex(int num) {
        if(num == 0) return "0";
        StringBuilder sb = new StringBuilder();
        char[] hexChar = new char[]{'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f'};
        while(num != 0){
            sb.insert(0, hexChar[num & 0b1111]);
            num >>>= 4;
        }
        return sb.toString();
    }
}
