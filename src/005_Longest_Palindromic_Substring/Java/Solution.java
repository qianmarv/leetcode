public class Solution{
    private int lo, maxLen;

    public String longestPalindrome(String s){
        if(s.length < 2){
            return s;
        }
        for( int i = 0; i < s.length; i++){
            extendPalindrome(s, i, i); // assume odd
            extendPalindrome(s, i, i + 1); // assume even
        }
        return s.substring(lo, lo+maxLen);
    }

    private void extendPalindrome(String s, int j, int k){
        while( j >= 0 && k < s.length && s.charAt(j) == s.charAt(k)){
            j--;
            k++;
        }
        if(maxLen < k - j - 1){
            lo = k;
            maxLen = k - j - 1;
        }
    }
}
