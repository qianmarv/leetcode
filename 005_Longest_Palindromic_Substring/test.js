let assert = require('assert');
let solution = require('./solution.js');

describe("Longest Palindromic Substring", function () {
            describe("Test Solution 1", function () {
                let solution1 = solution.longestPalindrome_1;
                let cases = [
                    ["aa", "aa"],
                    ["", ""],
                    ["a", "a"],
                    ["abaa", "aba"],
                    ["aaabaaaa", "aaabaaa"],
                    ["baaabaaa", "aaabaaa"],
                    ["eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeebeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee",
                     "eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeebeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee"]
                ];
                for (let i = 0; i < cases.length; i++) {
                    it(cases[i][0] + " should return " + cases[i][1], function () {
                        assert.equal(solution1(cases[i][0]), cases[i][1]);
                    });
                }
            })
})