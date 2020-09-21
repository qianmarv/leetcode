class Solution {
    //Runtime: 2 ms, faster than 96.86%
    //Memory Usage: 36.2 MB, less than 61.87%
    public boolean judgeSquareSum(int c){
        int i = 0;
        int mid = int(Math.sqrt(c));
        while( i <= mid ){
            int powSum = i * i + mid * mid;
            if(powSum < c){
                i++;
            }else if(powSum > c){
                mid--;
            }else{
                return true;
            }
        }
        return false;
    }
}
