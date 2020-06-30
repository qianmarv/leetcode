/**
 * @param {string} s
 * @return {number}
 */
var lengthOfLongestSubstring_1 = function(s) {
    var substr = ""
        max    = 0;
    for(var i = 0; i < s.length; i++){
        substr = s.charAt(i);
        for(var j = i + 1; j < s.length; j++){
            var c= s.charAt(j);
            if(substr.indexOf(c) === -1){
                substr += c;
            }else{
                break;
            }
        }
        max = substr.length > max ? substr.length : max;
    }
    return max;
};
var lengthOfLongestSubstring_2 = function(s) {
    let substr = ""
        max    = 0;
    for(let i = 0; i < s.length; i++){
        let idx = s.indexOf(s,i+1);
        
    }
    return max;
};

var str = " ";
console.log("Test string: "+ str + " -> Should be: 3 (abcg)");
console.log("lengthOfLongestSubstring_1: => " + lengthOfLongestSubstring_1(str));