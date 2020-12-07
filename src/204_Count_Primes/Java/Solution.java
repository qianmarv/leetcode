class Solution {
    //Runtime: 11 ms, faster than 95.71%
    //Memory Usage: 37.8 MB, less than 7.10%
    public int countPrimes(int n) {
        if(n < 2) return 0;
        boolean[] notPrimes = new boolean[n+1];
        int ret = 0;
        for(int i = 2; i < n; i++){
            if(notPrimes[i]) continue;
            ret++;
            for(long j = (long)i*i; j < n; j += i){
                notPrimes[(int)j] = true;
            }
        }
        return ret;
    }
}
