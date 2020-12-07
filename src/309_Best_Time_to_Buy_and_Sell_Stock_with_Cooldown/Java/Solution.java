class Solution {
    //Runtime: 0 ms, faster than 100.00%
    //Memory Usage: 36.8 MB, less than 11.94%
    public int maxProfit(int[] prices){
        if(prices == null || prices.length < 2 ) return 0;
        int[] hold = new int[prices.length];
        int[] sell = new int[prices.length];
        hold[0] = -1 * prices[0];
        sell[0] = 0;

        for(int i = 1; i < prices.length; i++){
            sell[i] = Math.max(sell[i-1], hold[i-1]+prices[i]);
            hold[i] = Math.max(hold[i-1], (i>2 ?sell[i-2]:0)-prices[i];
        }
        return sell[prices.length-1];
    }
}
