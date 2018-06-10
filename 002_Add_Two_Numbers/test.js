var assert = require('assert');
var solution = require('./solution.js');

describe('Add Two Numbers', function(){
    //prepare data
    var getRandomOf = function(Num){
        return Math.floor(Math.random()*(10**Num));
    };
    var num1 = getRandomOf(10);
    var num2 = getRandomOf(10);
    var expt = num1 + num2;
    describe('Solution 1: - Two Chain', function(){
        it('Should equal to ' , function(){
            var l1 = solution.createNode(String(num1));
            var l2 = solution.createNode(String(num2));
            var act = Number(solution.getStrNum(solution.addTwoNumbers_1(l1, l2)));
            assert.equal(expt, act);
        });
    });
    describe('Solution 2: - Two Chain - Improve Perf', function(){
        it('Should equal to ' , function(){
            var l1 = solution.createNode(String(num1));
            var l2 = solution.createNode(String(num2));
            var act = Number(solution.getStrNum(solution.addTwoNumbers_2(l1, l2)));
            assert.equal(expt, act);
        });
    });
});
