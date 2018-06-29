let assert = require('assert');
let solutions = require('./solution.js');

describe("Longest Palindromic Substring", function () {
            let cases = [
                ["", ""],
                ["a", "a"],
                ["aa", "aa"],
                ["aaa", "aaa"],
                ["aaaa", "aaaa"],
                ["aaaaa", "aaaaa"],
                ["aaaaaa", "aaaaaa"],
                ["abaa", "aba"],
                ["aaabaaaa", "aaabaaa"],
                ["baaabaaa", "aaabaaa"],
                ["aaxaaxaa", "aaxaaxaa"],
                ["abbaxabbaxabbaxabba", "abbaxabbaxabbaxabba"],
                ["abaxabaxaba", "abaxabaxaba"],
                ["abcdefghijklmnokprstuvwxyzabcdefghijklmnokprstuvwxyzabcdefghijklmnokprstuvwxyzabcdefghijklmnokprstuvwxyzabcdefghijklmnokprstuvwxyzabcdefghijklmnokprstuvwxyzabcdefghijklmnokprstuvwxyzabcdefghijklmnokprstuvwxyzabcdefghijklmnokprstuvwxyzabcdefghijklmnokprstuvwxyzabcdefghijklmnokprstuvwxyzabcdefghijklmnokprstuvwxyz", "a"],
                ["eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeebeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee",
                 "eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeebeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee"
                ]
            ];

            describe("Test Solution 1", function () {
                let solution = solutions.longestPalindrome_1;
                for (let i = 0; i < cases.length; i++) {
                    it(cases[i][0] + " should return " + cases[i][1], function () {
                        assert.equal(solution(cases[i][0]), cases[i][1]);
                    });
                }
            });
            describe("Test Solution 2", function () {
                let solution = solutions.longestPalindrome_2;
                for (let i = 0; i < cases.length; i++) {
                    it(cases[i][0] + " should return " + cases[i][1], function () {
                        assert.equal(solution(cases[i][0]), cases[i][1]);
                    });
                }
            })
})