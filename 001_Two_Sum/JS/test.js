var assert = require('assert');
var solution = require('./solution.js');
describe('Two Sum', function() {
    describe('Solution 1: Brute Force', function() {
        it('Should euqal', function() {
            var iArr = solution.twoSum_1([2, 7, 11, 15],22);
            assert.equal(iArr[0], 1);
            assert.equal(iArr[1], 3);
        });
    });
    describe('Solution 2: Hash Map', function(){
        it('Should equal', function(){
            var iArr = solution.twoSum_2([2, 7, 11, 15],22);
            assert.equal(iArr[0], 1);
            assert.equal(iArr[1], 3);
        });
    });
});
