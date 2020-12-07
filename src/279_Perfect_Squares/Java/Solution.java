import java.util.*;
class Solution{

    //DP Solution
    //Runtime: 32 ms, faster than 75.41%
    //Memory Usage: 38.7 MB, less than 76.23%
    public int numSquaresDP(int n){
        var dp = new int[n+1];
        dp[1] = 1;
        //TODO need initialize dp[n] to zero?
        for(int i = 2; i <= n; i++){
            dp[i] = dp[i-1]+1;
            for(int j = 2; true; j++){
                int t = j * j;
                //if j is perfect square number
                if(t > i){
                    break;
                }else{
                    dp[i] = Math.min(dp[i], dp[i-t]+1);
                }
            }
        }
        return dp[n];
    }
    //BFS Solution
    //Runtime: 173 ms, faster than 17.96% o
    //Memory Usage: 261.8 MB, less than 5.01%
    public int numSquaresBFS(int n){
        int depth = 0;
        List<Integer> sqrs = generateSquares(n);

        Queue<Integer> queue = new LinkedList<>();
        queue.add(n);
        while(!queue.isEmpty()){
            int size = queue.size();
            depth++;
            while(size-- > 0){
                int curr = queue.poll();
                for(int sqr: sqrs){
                    int rest = curr - sqr;
                    if(rest == 0) return depth;
                    else if(rest > 0) queue.add(rest);
                }
            }
        }
        return -1;
    }
    private List<Integer> generateSquares(int n){
        List<Integer> result = new ArrayList<>();
        for(int i = 1; true; i++){
            int sqr = i * i;
            if(sqr > n) break;
            result.add(sqr);
        }
        return result;
    }
    public static void main(String[] args){
        Solution so = new Solution();
        int n = Integer.parseInt(args[0]);
        System.out.printf("Given N=%d, Least number of PS=%d.\n", n, so.numSquaresBFS(n));
    }
}
