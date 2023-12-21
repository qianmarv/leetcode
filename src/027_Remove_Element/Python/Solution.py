#!/usr/bin/env python3

class Solution:
    def removeElement(self, nums: List[int], val: int) -> int:
        fp = 0
        tp = len(nums) - 1
        while fp <= tp:
            if nums[fp] == val:
                nums[fp] = nums[tp]
                tp -=  1
            else:
                fp += 1
        return tp + 1
