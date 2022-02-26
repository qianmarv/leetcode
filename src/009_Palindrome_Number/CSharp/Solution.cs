public class Solution {
    public bool IsPalindrome(int x) {
        return x < 0 ? false : ( x < 10 ? true : x == reverse(x) );
    }
    public int reverse(int x){
        int result = 0;
        while(x > 0){
            result = result * 10 + x % 10;
            x = x / 10;
        }
        return result;
    }
}
