class Solution {
    //Runtime: 0 ms, faster than 100.00%
    //Memory Usage: 39.2 MB, less than 95.55%
    public char nextGreatestLetter(char[] letters, char target) {
        int lo = 0;
        int hi = letters.length-1;
        while(lo <= hi){
            int mi = lo + (hi - lo)/2;
            char c = letters[mi];
            if(c > target) hi = mi - 1;
            else lo = mi + 1;
        }
        return lo == letters.length ? letters[0] : letters[lo];
    }
}
