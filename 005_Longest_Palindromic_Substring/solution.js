/*
Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.

Example 1:

Input: "babad"
Output: "bab"
Note: "aba" is also a valid answer.


Example 2:

Input: "cbbd"
Output: "bb"


*/

module.exports = {
        isPalindromic: function (s) {
            for (let i = 0, j = s.length - 1; i < j; i++, j--) {
                if (s[i] !== s[j]) {
                    return false;
                }
            }
            return true;
        },
        longestPalindrome_1: function (s) {
            let result = [0,0];
            let cachePairs
            for (let i = 0; i < s.length; i++) {
                let j = s.lastIndexOf(s[i]);
                if(result[1] - result[0] + 1 > s.length - i){
                    break;
                }
                for (; j > i; j = s.lastIndexOf(s[i], j-1)) {
                    if(result[1] - result[0] > j - i){
                        break;
                    }
                    var isPalindromic = true;
                    for (let m = i+1, n = j-1; m <= n; m++, n--) { // Time consumer
                        if (s[m] !== s[n]) {
                             isPalindromic = false;
                             break;
                        }
                    }
//                    console.log("substring="+s.substring(i,j+1)+";Palindromic: "+isPalindromic);
                    // is Palindromic
                    if(isPalindromic){
                        result = [i, j];
                        break; // Outside > Inside
                    }
                }
            }
            return s.substring(result[0], result[1]+1);
        }
}