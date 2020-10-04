public class Solution {
    //Runtime: 1 ms, faster than 98.97%
    //Memory Usage: 39 MB, less than 90.49%
    public int maxProfit(int[] prices){
        if(prices.length < 2) return 0;
        int in = prices[0];
        int result = 0;
        for(int i = 1; i < prices.length; i++){
            result = Math.max(result, prices[i] - in);
            in = Math.min(prices[i], in);
        }
        return result;
    }
    public static void main(String[] args) {
        Solution so = new Solution();
        int[] prices = new int[]{7,1,5,3,6,4};
        System.out.printf("Max Profit = %d\n", so.maxProfit(prices));
    }
}
