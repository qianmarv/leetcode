//Runtime: 4 ms, faster than 88.62%
//Memory Usage: 2.9 MB, less than 56.91%
func minCostClimbingStairs(cost []int) int {
    curr := 0
    pre1 := 0
    pre2 := 0
    for i := 2; i <= len(cost); i ++ {
        if pre1 + cost[i-1] <= pre2 + cost[i-2] {
            curr = pre1 + cost[i-1]
        }else {
            curr = pre2 + cost[i-2]
        }
        pre2 = pre1;
        pre1 = curr;
    }
    return curr;
}
