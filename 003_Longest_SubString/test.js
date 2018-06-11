var assert = require('assert');
var solution = require('./solution.js');

describe("Get Length of Longest SubString", function(){
    describe('Solution 1', function(){
        it('`abcabcbb` should return 3', function(){
            assert.equal(solution.getLengthOfLongestSubstring_1('abcabcbb'), 3);
        });
        it('`bbbbb` should return 1', function(){
            assert.equal(solution.getLengthOfLongestSubstring_1('bbbbb'), 1);
        });
        it('`pwwkew` should return 3', function(){
            assert.equal(solution.getLengthOfLongestSubstring_1('pwwkew'), 3);
        });
    });
});
