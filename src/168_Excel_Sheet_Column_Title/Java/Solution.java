class Solution {
    //Runtime: 0 ms, faster than 100.00%
    //Memory Usage: 35.8 MB, less than 10.93%
    public String convertToTitle(int n) {
        StringBuilder sb = new StringBuilder();
        while(n > 0){
            int r = n % 26;
            n /= 26;
            if(r == 0) n--;
            sb.append(get26Code(r));
        }
        return sb.reverse().toString();
    }
    private char get26Code(int n){
        if(n == 0) return 'Z';
        return (char)(n - 1 + 'A');
    }
}
