import java.util.Arrays;
public class Solution {
	//Runtime: 18 ms, faster than 64.89%
	//Memory Usage: 38.1 MB, less than 5.38%
    public boolean canPartition(int[] nums) {
		int total = sum(nums);
		if(total % 2 == 1) return false;
		int W = total / 2;

		boolean[] dp = new boolean[W+1];
        dp[0] = true;
		for(int num: nums){
			for(int j = W; j >= num; j--){
				dp[j] = dp[j] || dp[j-num];
			}
		}
		return dp[W];
	}

	private int sum(int[] nums){
		int ret = 0;
		for(int num: nums){
			ret += num;
		}
		return ret;
	}

	// Warm up and learn 0/1 knapsack
    public int knapsack2(int W, int N, int[] weights, int [] values){
		int[][] dp = new int[N+1][W+1];
		for(int i = 1; i <= N; i++){
			int wi = weights[i-1];
			int vi = values[i-1];
			for(int j = 1; j <= W; j++){
				if(j >= wi){
					dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-wi]+vi);
				}else{
					dp[i][j] = dp[i-1][j];
				}
		    }
		}
		return dp[N][W];
    }
	public int knapsack(int W, int N, int[] weights, int[] values){
		int[] dp = new int[W+1];
		for(int i = 1; i <= N; i++){
			int wi = weights[i-1];
			int vi = values[i-1];
			for(int j = W; j > 0; j--){
				if(j >= wi){
					//dp[j] stores value which not choose current item
					dp[j] = Math.max(dp[j], vi+dp[j-wi]);
				}
			}
		}
		return dp[W];
	}
    public static void main(String[] args) {
		int[] weights = new int[]{1,3,4,6};
		int[] values  = new int[]{2,4,5,9};
		Solution so = new Solution();
		System.out.printf("MaxV: %d\n", so.knapsack(7, 4, weights, values));
    }
}
