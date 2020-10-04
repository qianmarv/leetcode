public class Solution {
    //Runtime: 0 ms, faster than 100.00%
    //Memory Usage: 39 MB, less than 90.72%
    public int maxProfit(int[] prices){
        if(prices.length < 2) return 0;
        int max = 0;
        for(int i = 1; i < prices.length; i++){
            if(prices[i] > prices[i-1]){
                max += prices[i] - prices[i-1];
            }
        }
        return max;
    }
}
