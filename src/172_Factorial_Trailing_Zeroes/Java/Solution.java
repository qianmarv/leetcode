class Solution {
    //Runtime: 0 ms, faster than 100.00%
    //Memory Usage: 35.7 MB, less than 14.56%
    public int trailingZeroes(int n) {
        return n == 0 ? 0 : n / 5 + trailingZeroes(n/5);
    }
}
