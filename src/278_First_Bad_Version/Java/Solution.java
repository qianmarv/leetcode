/* The isBadVersion API is defined in the parent class VersionControl.
   boolean isBadVersion(int version); */
public class Solution extends VersionControl {
    //Runtime: 12 ms, faster than 99.16%
    //Memory Usage: 35.5 MB, less than 98.58%
    public int firstBadVersion(int n) {
        int lo = 1;
        int hi = n;
        while(lo <= hi){
            int mi = lo + (hi - lo)/2;
            if(isBadVersion(mi)){
                hi = mi - 1;
            }else{
                lo = mi + 1;
            }
        }
        return lo;
    }
}
