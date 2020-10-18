class Solution {
    //Runtime: 35 ms, faster than 48.95%
    //Memory Usage: 39.1 MB, less than 19.44%
    public int findLongestChain(int[][] pairs) {
        int[] dp = new int[pairs.length];
        dp[0] = 1;
        Array.sort(pairs, (a,b) -> (a[0] - b[0]));
        for(int i = 1; i < pairs.length; i++){
            int len  = 1;
            for(int j = 0; j < i; j++){
                if(pairs[i][0] > pairs[j][1]){
                    len = Math.max(len, dp[j]+1);
                }
            }
            dp[i] = len;
        }
        int result = 0;
        for(int i = 0; i < dp.length; i++){
            result = Math.max(result, dp[i]);
        }
        return result;
    }
}
