class NumArray{
    private int[] numSum;

    public NumArray(int[] nums){
        int sum = 0;
        numSum = new int[nums.length];
        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
            numSum[i] = sum;
        }
    }

    //Runtime: 6 ms, faster than 100.00% of Java online submissions for Range Sum Query - Immutable.
    public int sumRange(int i, int j){
        return i == 0? numSum[j] : (numSum[j] - numSum[i-1]);
    }
}
