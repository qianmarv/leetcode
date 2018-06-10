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
