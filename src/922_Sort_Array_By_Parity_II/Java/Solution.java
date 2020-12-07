class Solution {
    //Runtime: 2 ms, faster than 99.37%
    //Memory Usage: 39.9 MB, less than 6.82%
    public int[] sortArrayByParityII(int[] A) {
        int i = 0, j = 1;
        while( i < A.length && j < A.length){
            if(A[i]%2 == 0){
                i += 2;
                continue;
            }
            if(A[j]%2 != 0){
                j += 2;
                continue;
            };
            int tmp = A[i];
            A[i] = A[j];
            A[j] = tmp;
        }
        return A;
    }
}
