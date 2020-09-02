class Solution {
    public int reverse(int x) {
        int result = 0;
        while(x != 0){
            int remainder = x % 10;

            // Check Overflow
            // if(result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && remainder > Integer.MAX_VALUE % 10 )) return 0;
            // if(result < Integer.MIN_VALUE / 10 || (result == Integer.MIN_VALUE / 10 && remainder < Integer.MIN_VALUE % 10 )) return 0;

            int y = result * 10 + remainder;

            // Another way to check overflow
            if(result != (y - remainder)/10 ) return 0;

            result = y;
            x = x / 10;
        }
        return result;
    }
    public static void main(String[] argv){
        Solution sol = new Solution();

        //Tests
        System.out.println(sol.reverse(Integer.parseInt(argv[0])));
    }
}
