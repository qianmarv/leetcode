class Solution {
    //Runtime: 4 ms, faster than 52.76%
    //Memory Usage: 49.2 MB, less than 6.71%
    public int maxProfit(int[] prices, int fee) {
        if(prices == null || prices.length < 2) return 0;
        int[] sell = new int[prices.length];
        int[] hold = new int[prices.length];
        sell[0] = 0;
        hold[0] = -1 * prices[0];
        for(int i = 1; i < prices.length; i++){
            sell[i] = Math.max(sell[i-1], hold[i-1]+prices[i]-fee);
            hold[i] = Math.max(hold[i-1], sell[i-1]-prices[i]);
        }
        return sell[prices.length-1];
    }
}
