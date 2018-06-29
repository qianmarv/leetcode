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
            // Outside - In
            let result = [0, 0];
            for (let i = 0; i < s.length && result[1] - result[0] + 1 < s.length - i; i++) {
                let j = s.lastIndexOf(s[i]);
                for (; j > i && result[1] - result[0] < j - i; j = s.lastIndexOf(s[i], j - 1)) {
                    var isPalindromic = true;
                    for (let m = i + 1, n = j - 1; m <= n; m++, n--) { // Time consumer
                        if (s[m] !== s[n]) {
                            isPalindromic = false;
                            break;
                        }
                    }
                    if (isPalindromic) {
                        result = [i, j];
                        break;
                    }
                }
            }
            return s.substring(result[0], result[1] + 1);
        },
        longestPalindrome_2: function (s) {
            //Inside - Out
            let result = [0, 1];
            let farIndex = 0;
            let nearIndex = 0;
            let i = 1;
            for (; i < s.length; i++) {
                // 回文的条件：第一个/和前一个相等/和再往前一个相等/前一个在回文区域+回文区域前一个相等
                if (s[i] === s[farIndex - 1]) { //Keep Rolling
                    //                    console.log("substring: " + s.substring(farIndex, i+1));
                    farIndex--;
                } else if (s[i] === s[nearIndex - 1]) {
                    farIndex = nearIndex - 1;
                } else {
                    if (i - farIndex > result[1] - result[0]) {
                        result[0] = farIndex;
                        result[1] = i;
                    }
                    farindex = i;
                }

                if (s[i] === s[i - 2]) {
                    nearIndex = i - 2;
                } else if (s[i] === s[i - 1]) {
                    nearIndex = i - 1;
                } else {
                    nearIndex = -1;
                }
            }
            if (i - farIndex > result[1] - result[0]) {
                result[0] = farIndex;
                result[1] = i;
            }

            return s.substring(result[0], result[1]);
        }
}