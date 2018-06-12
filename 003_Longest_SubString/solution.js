/* Problem
   Longest Substring Without Repeating Characters
   link: https://leetcode.com/problems/longest-substring-without-repeating-characters/description/

   Given a string, find the length of the longest substring without repeating characters.

   Examples:

   Given "abcabcbb", the answer is "abc", which the length is 3.

   Given "bbbbb", the answer is "b", with the length of 1.

   Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
*/
module.exports = {
    // Probably because of constructing the map is expensive, the performance is bad, around 500ms.
    getLengthOfLongestSubstring_1 : function(s){
        let len = 0;
        let maxLen = 0;
        let currentMap = {};
        for(let i = 0; i < s.length; i++){
            let j = currentMap[s[i]];
            if(j === undefined){
                currentMap[s[i]] = i;
                len ++;
            }else{
                if(len > maxLen){
                    maxLen = len;
                }
                len = 0;
                currentMap = {};
                i = j;
            }
        }
        return maxLen > len ? maxLen : len;
    },
    // Best!!! 76ms
    glols_2: function(s){
        let maxLen = 0;
        let i, j;
        for(i = 0, j = 0; i < s.length; i++){
            let idx = s.indexOf(s[i], j);
            if(idx !== -1 && idx < i){ // find repeate char
                let len = i - j;
                if(len > maxLen ){
                    maxLen = len;
                }
                j = idx + 1;
            }
        }
        return Math.max(maxLen, i -j);
    }
}
