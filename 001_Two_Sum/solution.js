/* Problem
   Two Sum
   Link: https://leetcode.com/problems/two-sum/description/

   Given an array of integers, return indices of the two numbers such that they add up to a specific target.

   You may assume that each input would have exactly one solution, and you may not use the same element twice.

   Example:

   Given nums = [2, 7, 11, 15], target = 9,

   Because nums[0] + nums[1] = 2 + 7 = 9,
   return [0, 1].
  */
module.exports = {
    twoSum_1 : function(nums, target){
        for(var i = 0; i < nums.length; i++){
            for(var j = i+1; j < nums.length; j++){
                if(nums[i] + nums[j] === target){
                    return [i, j];
                }
            }
        }
        throw "No correct result";
    },

    twoSum_2: function(nums, target){
        var map = {};
        for(var i = 0; i < nums.length; i++){
            var v = target - nums[i];
            if( map[v] !== undefined){
                return [map[v], i];
            }
            map[nums[i]] = i;
        }
        throw "No correct result";
    }
}
