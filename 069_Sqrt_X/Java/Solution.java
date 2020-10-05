class Solution {
    //Runtime: 1 ms, faster than 99.99%
    //Memory Usage: 36 MB, less than 95.24%
    public int mySqrt(int x) {
        // y = x/y; find y from 0~x
        int lo = 1;
        int hi = x;
        while(lo <= hi){
            int mi = lo + (hi-lo)/2;
            int sqrt = x / mi;
            if(sqrt == mi) return mi;
            else if(sqrt < mi){
                hi = mi - 1;
            }else{
                lo = mi + 1;
            }
        }
        return hi;
    }
}
