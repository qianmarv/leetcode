let assert = require('assert');
let solution = require('./solution.js');

describe("Get Median of Two Sorted Arrays", function(){
    describe('Solution 1', function(){
        it('[1, 3] & [2] should return 2', function(){
            assert.equal(solution.findMedianSortedArrays1([1,3], [2]), 2);
        });
        it('[1, 2] & [3, 4] should return 2.5', function(){
            assert.equal(solution.findMedianSortedArrays1([1,2], [3,4]), 2.5);
        });

        it('[1] & [2,3,4,5,6,7,8,9,10] should return 5.5', function(){
            assert.equal(solution.findMedianSortedArrays1([1], [2,3,4,5,6,7,8,9,10]), 5.5);
        });
    });
    describe('Solution 2', function(){
        it('[1, 3] & [2] should return 2', function(){
            assert.equal(solution.findMedianSortedArrays2([1,3], [2]), 2);
        });
        it('[1, 2] & [3, 4] should return 2.5', function(){
            assert.equal(solution.findMedianSortedArrays2([1,2], [3,4]), 2.5);
        });
        it('[2, 3] & [1, 4] should return 2.5', function(){
            assert.equal(solution.findMedianSortedArrays2([2,3], [1,4]), 2.5);
        });
        it('[1] & [2,3,4,5,6,7,8,9,10] should return 5.5', function(){
            assert.equal(solution.findMedianSortedArrays2([1], [2,3,4,5,6,7,8,9,10]), 5.5);
        });
    });
});
